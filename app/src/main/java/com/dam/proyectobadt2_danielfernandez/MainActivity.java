package com.dam.proyectobadt2_danielfernandez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;
import com.dam.proyectobadt2_danielfernandez.listas.ListaTerremotos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TerremotoAdapter adapter;

    Button btnFil;
    Button btnCon;
    TextView tvFiltro;
    RecyclerView rvTerremotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFil = findViewById(R.id.btnFiltro);
        btnCon = findViewById(R.id.btnConsultar);
        tvFiltro = findViewById(R.id.tvFiltro);
        rvTerremotos = findViewById(R.id.rvTerremotos);
        rvTerremotos.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Terremoto> datos = new ArrayList<>();
        adapter = new TerremotoAdapter(datos);
        rvTerremotos.setAdapter(adapter);

        adapter.setDatos(ListaTerremotos.getListaTerremotos());


        btnFil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FiltroDialog dialog = new FiltroDialog();
                dialog.show(getSupportFragmentManager(), "FiltroDialog");

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