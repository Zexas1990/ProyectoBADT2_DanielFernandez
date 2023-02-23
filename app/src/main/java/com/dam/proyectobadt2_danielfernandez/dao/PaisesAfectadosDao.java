package com.dam.proyectobadt2_danielfernandez.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dam.proyectobadt2_danielfernandez.entity.PaisAfectado;
import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;

import java.util.List;

@Dao
public interface PaisesAfectadosDao {

    @Query("SELECT * FROM PAISES_AFECTADOS")
    public List<PaisAfectado> getAll();

    @Insert
    void insertAll(List<PaisAfectado> paisesAfectados);

    @Query("SELECT * FROM PAISES_AFECTADOS WHERE pais = :pais")
    public PaisAfectado selectById(String pais);

    @Query("SELECT DISTINCT pais FROM PAISES_AFECTADOS")
    public List<String> getAllPaises();
}
