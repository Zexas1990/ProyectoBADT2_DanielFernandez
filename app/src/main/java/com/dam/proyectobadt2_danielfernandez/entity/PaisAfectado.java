package com.dam.proyectobadt2_danielfernandez.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;


import java.util.Date;

@Entity(tableName = "PAISES_AFECTADOS",
        primaryKeys = {"fechaHora", "pais"}, foreignKeys = @ForeignKey(entity = Terremoto.class, parentColumns = "fechaHora",
        childColumns = "fechaHora"))
public class PaisAfectado {

    @ColumnInfo(name = "fechaHora")
    @NonNull
    public String fechaHora;

    @ColumnInfo(name = "pais")
    @NonNull
    public String paisAfectado;


    public PaisAfectado(@NonNull String fechaHora, @NonNull String paisAfectado) {
        this.fechaHora = fechaHora;
        this.paisAfectado = paisAfectado;
    }

    @NonNull
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(@NonNull String fechaHora) {
        this.fechaHora = fechaHora;
    }

    @NonNull
    public String getPaisAfectado() {
        return paisAfectado;
    }

    public void setPaisAfectado(@NonNull String paisAfectado) {
        this.paisAfectado = paisAfectado;
    }
}
