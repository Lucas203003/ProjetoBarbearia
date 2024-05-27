package com.example.barbearia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;

public class AppointmentActivity extends AppCompatActivity {

    private EditText customerNameEditText, dateEditText, timeEditText;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_activity);

        // Inicializando os itens na tela
        customerNameEditText = findViewById(R.id.customerNameEditText);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);

        // Abrir ou criar o banco de dados SQLite
        try {
            db = openOrCreateDatabase("AgendamentosDB", MODE_PRIVATE, null);
            // Criar a tabela se ainda não existir
            db.execSQL("CREATE TABLE IF NOT EXISTS Agendamentos (CustomerName TEXT, Date TEXT, Time TEXT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Configuração do botão para agendar um horário
        Button scheduleAppointmentButton = findViewById(R.id.scheduleAppointmentButton);
        scheduleAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Variáveis para obter os valores digitados pelo usuário
                String customerName = customerNameEditText.getText().toString().trim();
                String date = dateEditText.getText().toString().trim();
                String time = timeEditText.getText().toString().trim();

                // Verifica se os campos estão preenchidos
                if (customerName.isEmpty() || date.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AppointmentActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Insere os dados no banco de dados SQLite
                    insertData(customerName, date, time);

                    // Criar um Intent para iniciar a nova atividade
                    Intent intent = new Intent(AppointmentActivity.this, AppointmentConfirmationActivity.class);
                    // Passar os dados para a nova atividade
                    intent.putExtra("customerName", customerName);
                    intent.putExtra("date", date);
                    intent.putExtra("time", time);
                    // Iniciar a nova atividade
                    startActivity(intent);

                    // Finalizar a atividade atual
                    finish();
                }
            }
        });
    }

    private void insertData(String customerName, String date, String time) {
        ContentValues values = new ContentValues();
        values.put("CustomerName", customerName);
        values.put("Date", date);
        values.put("Time", time);
        db.insert("Agendamentos", null, values);
        Cursor cursor = db.query(
                "Agendamentos",            // Nome da tabela
                new String[]{"CustomerName", "Date", "Time"}, // Colunas que você deseja recuperar
                null,                      // Cláusula WHERE (opcional)
                null,                      // Argumentos da cláusula WHERE (opcional)
                null,                      // GROUP BY (opcional)
                null,                      // HAVING (opcional)
                null                       // ORDER BY (opcional)
        );
    }
}
