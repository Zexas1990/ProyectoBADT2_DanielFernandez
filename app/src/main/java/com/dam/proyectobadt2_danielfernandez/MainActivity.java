package com.dam.proyectobadt2_danielfernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnFil;
    Button btnCon;
    TextView tvFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFil = findViewById(R.id.btnFiltro);
        btnCon = findViewById(R.id.btnConsultar);
        tvFiltro = findViewById(R.id.tvFiltro);




        btnFil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));

        btnCon.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Hacer la carga inicial si esta vacio

            }
        }));
    }
}