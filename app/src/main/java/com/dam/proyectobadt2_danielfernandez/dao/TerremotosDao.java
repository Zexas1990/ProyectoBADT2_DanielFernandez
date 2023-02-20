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

    @Query("SELECT * FROM TERREMOTOS WHERE fechaHora = :fechaHora")
    public Terremoto selectById(String fechaHora);

    @Insert
    void insertAll(List<Terremoto> terremotos);

    
}
