package com.dam.proyectobadt2_danielfernandez.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;

import java.util.List;

@Dao
public interface TerremotosDao {

    @Query("SELECT * FROM TERREMOTOS ORDER BY MAGNITUD DESC")
    public List<Terremoto> getAll();

    @Insert
    void insertAll(List<Terremoto> terremotos);
/*
    //Si se ha seleccionado un mes, se mostrarán los terremotos cuya fecha contenga el mes seleccionado.
    @Query("SELECT * FROM TERREMOTOS WHERE fechaHora LIKE '%:mes%'")
    public List<Terremoto> filtroMes(String mes);

    //Si se ha seleccionado un año, se mostrarán los terremotos cuya fecha contenga el año seleccionado.
    @Query("SELECT * FROM TERREMOTOS WHERE fechaHora LIKE '%:ano%'")
    public List<Terremoto> filtroAno(String ano);

    //Si se ha seleccionado un país, se mostrarán todos los terremotos que hayan afectado a dicho país
    @Query("SELECT * FROM TERREMOTOS TER INNER JOIN PAISES_AFECTADOS PA ON TER.fechaHora = PA.fechaHora " +
            "WHERE PA.pais LIKE '%:pais%'")
    public List<Terremoto> filtroPais(String pais);

    //Si se ha seleccionado un mes y un año, se mostrarán los terremotos cuya fecha contenga el mes seleccionado y contenga el año seleccionado.
    @Query("SELECT * FROM TERREMOTOS WHERE fechaHora LIKE '%:mes%' AND fechaHora LIKE '%:ano%'")
    public List<Terremoto> filtroMesAno(String mes, String ano);


    //Si se ha seleccionado un mes y un país, se mostrarán los terremotos cuya fecha contenga el mes seleccionado y que hayan afectado a dicho país.
    @Query("SELECT * FROM TERREMOTOS TER INNER JOIN PAISES_AFECTADOS PA ON TER.fechaHora = PA.fechaHora " +
            "WHERE fechaHora LIKE '%:mes%' AND PA.pais LIKE '%:pais%'")
    public List<Terremoto> filtroMesPais(String mes, String pais);


    //Si se ha seleccionado un año y un país, se mostrarán los terremotos cuya fecha contenga el año seleccionado y que hayan afectado a dicho país.
    @Query("SELECT * FROM TERREMOTOS TER INNER JOIN PAISES_AFECTADOS PA ON TER.fechaHora = PA.fechaHora " +
            "WHERE fechaHora LIKE '%:ano%' AND PA.pais LIKE '%:pais%'")
    public List<Terremoto> filtroAnoPais(String ano, String pais);


    //Si se ha seleccionado un mes, un año y un país, se mostrarán los terremotos cuya fecha contenga el mes seleccionado, contenga el año seleccionado y que hayan afectado a dicho país.
    @Query("SELECT * FROM TERREMOTOS TER INNER JOIN PAISES_AFECTADOS PA ON TER.fechaHora = PA.fechaHora " +
            "WHERE fechaHora LIKE '%:mes%' AND fechaHora LIKE '%:ano%' AND PA.pais LIKE '%:pais%'")
    public Terremoto filtroMesAnoPais(String mes, String ano, String pais);



*/

    
}


/*




	.








 */