package com.dam.proyectobadt2_danielfernandez.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.dam.proyectobadt2_danielfernandez.dao.PaisesAfectadosDao;
import com.dam.proyectobadt2_danielfernandez.dao.TerremotosDao;
import com.dam.proyectobadt2_danielfernandez.entity.PaisAfectado;
import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;

@Database(entities = {PaisAfectado.class, Terremoto.class}, version = 1, exportSchema = false)
public abstract class TerremotosDB extends RoomDatabase {
    public abstract TerremotosDao terremotoDao();
    public abstract PaisesAfectadosDao paisesAfectadosDao();


    private static TerremotosDB terremotosDB;

    public static TerremotosDB getDatabase(Context context) {
        if (terremotosDB == null) {
            terremotosDB = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TerremotosDB.class, "TERREMOTOS_DB")
                    .allowMainThreadQueries().build();
        }
        return terremotosDB;
    }



}
