package com.example.barbearia;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class AppointmentConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_confirmation_activity);

        // Obter os dados passados pela atividade anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String customerName = extras.getString("customerName");
            String date = extras.getString("date");
            String time = extras.getString("time");

            // Exibir os dados nos TextViews
            TextView customerNameTextView = findViewById(R.id.customerNameTextView);
            customerNameTextView.setText("Nome do Cliente: " + customerName);

            TextView dateTextView = findViewById(R.id.dateTextView);
            dateTextView.setText("Data: " + date);

            TextView timeTextView = findViewById(R.id.timeTextView);
            timeTextView.setText("Horário: " + time);
        }

        // Configurar o botão para voltar para a MainActivity
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar um Intent para voltar para a MainActivity
                Intent intent = new Intent(AppointmentConfirmationActivity.this, MainActivity.class);
                startActivity(intent);
                // Finalizar todas as atividades anteriores
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }
}
