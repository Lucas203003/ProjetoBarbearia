package com.example.barbearia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private String[] services = {"Corte de Cabelo", "Barba", "Corte e Barba", "Tintura"};
        private CustomAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                ListView servicesListView = findViewById(R.id.servicesList);
                adapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, services);
                servicesListView.setAdapter(adapter);

                servicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // Define o item clicado como selecionado
                                adapter.setSelectedItem(position);

                                String selectedService = services[position];
                                Toast.makeText(MainActivity.this, "Serviço selecionado: " + selectedService, Toast.LENGTH_SHORT).show();
                        }
                });

                Button bookAppointmentButton = findViewById(R.id.bookAppointmentButton);
                bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(MainActivity.this, AppointmentActivity.class));
                        }
                });
        }
}
