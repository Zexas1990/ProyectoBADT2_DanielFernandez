package com.dam.proyectobadt2_danielfernandez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.proyectobadt2_danielfernandez.DB.TerremotosDB;
import com.dam.proyectobadt2_danielfernandez.dao.PaisesAfectadosDao;
import com.dam.proyectobadt2_danielfernandez.dao.TerremotosDao;
import com.dam.proyectobadt2_danielfernandez.entity.PaisAfectado;
import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;
import com.dam.proyectobadt2_danielfernandez.listas.ListaPaises;
import com.dam.proyectobadt2_danielfernandez.listas.ListaTerremotos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnDatosListener{

    TerremotoAdapter adapter;

    Button btnFil;
    Button btnCon;
    TextView tvFiltro;
    RecyclerView rvTerremotos;
    TerremotosDao terremotosDao;
    PaisesAfectadosDao paisesAfectadosDao;
    //OnDatosListener listener;
    String mes;
    String pais;
    String ano;
    int opcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        System.out.println("******** Cargando Datos **********");

        cargarDB();

        btnFil = findViewById(R.id.btnFiltro);
        btnCon = findViewById(R.id.btnConsultar);
        tvFiltro = findViewById(R.id.tvFiltro);
        rvTerremotos = findViewById(R.id.rvTerremotos);

        rvTerremotos.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Terremoto> datos = new ArrayList<>();
        adapter = new TerremotoAdapter(datos);
        rvTerremotos.setAdapter(adapter);








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

                cargarRecycler();
                //adapter.setDatos(ListaTerremotos.getListaTerremotos());


            }
        }));
    }

    private void cargarRecycler() {

        switch (opcion){
            case 1:
                adapter.setDatosDB(terremotosDao.filtroMesAnoPais(('%' + mes + '%'), ('%' + ano + '%'), ('%' + pais + '%')));
                break;
            case 2:
               adapter.setDatosDB(terremotosDao.filtroMesAno(('%' + mes + '%'), ('%' + ano + '%')));
                break;
            case 3:
                adapter.setDatosDB(terremotosDao.filtroMes(('%' + mes + '%')));
                break;
            case 4:
                adapter.setDatosDB(terremotosDao.filtroAno(('%' + ano + '%')));
                break;
            case 5:
                adapter.setDatosDB(terremotosDao.filtroPais(('%' + pais + '%')));
                break;
            case 6:
                adapter.setDatosDB(terremotosDao.filtroAnoPais(('%' + ano + '%'), ('%' + pais + '%')));
                break;
            case 7:
                adapter.setDatosDB(terremotosDao.filtroMesPais(('%' + mes + '%'), ('%' + pais + '%')));
                break;
            default:
                adapter.setDatosDB(terremotosDao.getAll());
                break;
        }
        if (adapter.getItemCount() == 0){
            Toast.makeText(this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
        }
    }

    private void pintarTextView() {
        if (pais != null && mes != null && ano != null) {
            //Filtramos por mes, año y pais
            tvFiltro.setText("Mes: " + mes + " Año: " + ano + " Pais: " + pais);
            opcion = 1;

        }else if (pais == null && mes != null && ano != null) {
            //Filtramos por mes y año
            tvFiltro.setText("Mes: " + mes + " Año: " + ano);
            opcion = 2;

        }else if (pais == null && mes != null && ano == null) {
            //Filtramos por mes
            tvFiltro.setText("Mes: " + mes);
            opcion = 3;

        }else if (pais == null && mes == null && ano != null) {
            //Filtramos por año
            tvFiltro.setText("Año: " + ano);
            opcion = 4;

        }else if (pais != null && mes == null && ano == null) {
            //Filtramos por pais
            tvFiltro.setText("Pais: " + pais);
            opcion = 5;

        }else if (pais != null && mes == null && ano != null) {
            //Filtramos por año y pais
            tvFiltro.setText(" Año: " + ano + " Pais: " + pais);
            opcion = 6;

        }else if(pais != null && mes != null && ano == null) {
            //Filtramos por mes y pais
            tvFiltro.setText("Mes: " + mes + " Pais: " + pais);
            opcion = 7;

        }


    }

    private void cargarDB() {
        TerremotosDB db = TerremotosDB.getDatabase(this);
        terremotosDao = db.terremotoDao();
        paisesAfectadosDao = db.paisesAfectadosDao();
        ArrayList<Terremoto> listaTerremotos = (ArrayList<Terremoto>) terremotosDao.getAll();
        ArrayList<PaisAfectado> listaPaises = (ArrayList<PaisAfectado>) paisesAfectadosDao.getAll();

        if(listaTerremotos.size() == 0){
            System.out.println("******** Introduciendo Terremotos **********");
            terremotosDao.insertAll(ListaTerremotos.getListaTerremotos());
        }
        if(listaPaises.size() == 0){
            System.out.println("******** Introduciendo Paises **********");
            paisesAfectadosDao.insertAll(ListaPaises.getListaPaises());

        }


    }


    public void onAceptarDatosListenerMesAnoPais(String mes, String ano, String pais){
        this.mes = mes;
        this.ano = ano;
        this.pais = pais;
        pintarTextView();
    }




}