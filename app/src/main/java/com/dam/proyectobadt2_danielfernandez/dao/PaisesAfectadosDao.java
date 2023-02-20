package com.dam.proyectobadt2_danielfernandez.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.dam.proyectobadt2_danielfernandez.entity.PaisAfectado;

import java.util.List;

@Dao
public interface PaisesAfectadosDao {

    @Query("SELECT * FROM PAISES_AFECTADOS")
    public List<PaisAfectado> getAll();

    @Query("SELECT * FROM PAISES_AFECTADOS WHERE pais = :pais")
    public PaisAfectado selectById(String pais);


}
