package com.example.barbearia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

        private String[] services = {"Corte de Cabelo", "Barba", "Corte e Barba", "Tintura"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Configurando o ListView de serviços
                ListView servicesListView = findViewById(R.id.servicesList);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, services);
                servicesListView.setAdapter(adapter);

                // Lidando com o clique nos itens da lista
                servicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String selectedService = services[position];
                                Toast.makeText(MainActivity.this, "Serviço selecionado: " + selectedService, Toast.LENGTH_SHORT).show();
                                // Aqui você pode adicionar lógica para tratar a seleção do serviço, como exibir mais informações ou preencher detalhes do agendamento.
                        }
                });

                // Configurando o botão de agendar horário
                Button bookAppointmentButton = findViewById(R.id.bookAppointmentButton);
                bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Abrir a atividade de agendamento de horário
                                startActivity(new Intent(MainActivity.this, AppointmentActivity.class));
                                //Toast.makeText(MainActivity.this, "Funcionalidade de agendamento será implementada em breve!", Toast.LENGTH_SHORT).show();
                        }
                });
        }
}
