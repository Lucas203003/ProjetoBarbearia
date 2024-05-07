package com.example.barbearia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class AppointmentActivity extends AppCompatActivity {

    private EditText customerNameEditText, dateEditText, timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_activity);

        // Inicializando as views
        customerNameEditText = findViewById(R.id.customerNameEditText);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);

        // Configurando o botão de agendar horário
        Button scheduleAppointmentButton = findViewById(R.id.scheduleAppointmentButton);
        scheduleAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os valores digitados pelo usuário
                String customerName = customerNameEditText.getText().toString().trim();
                String date = dateEditText.getText().toString().trim();
                String time = timeEditText.getText().toString().trim();

                // Validar se os campos estão preenchidos
                if (customerName.isEmpty() || date.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AppointmentActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Aqui você pode adicionar lógica para salvar o agendamento em algum lugar, como um banco de dados ou serviço web
                    // Por enquanto, vamos apenas exibir uma mensagem de confirmação
                    String confirmationMessage = "Agendamento confirmado para " + customerName + " no dia " + date + " às " + time;
                    Toast.makeText(AppointmentActivity.this, confirmationMessage, Toast.LENGTH_SHORT).show();
                    finish(); // Fechar a atividade após o agendamento
                }
            }
        });
    }
}
