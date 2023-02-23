package com.dam.proyectobadt2_danielfernandez.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;

@Entity(tableName = "TERREMOTOS", indices = {@Index(value = {"nombreDispositivo"}, unique = true)})
public class Terremoto {
    @PrimaryKey
    @NonNull
    public String fechaHora;

    @ColumnInfo(name = "nombreDispositivo")
    //@Index(unique = true)
    public String nombreDispositivo;

    @ColumnInfo(name = "magnitud")
    public double magnitud;

    @ColumnInfo(name = "coordenadasEpicentro")
    public String coordenadasEpicentro;

    @ColumnInfo(name = "lugar")
    public String lugar;

    @ColumnInfo(name = "cantidadMuertos")
    public String cantidadMuertos;

    public Terremoto(@NonNull String fechaHora, double magnitud, String nombreDispositivo, String coordenadasEpicentro, String lugar, String cantidadMuertos) {
        this.fechaHora = fechaHora;
        this.nombreDispositivo = nombreDispositivo;
        this.magnitud = magnitud;
        this.coordenadasEpicentro = coordenadasEpicentro;
        this.lugar = lugar;
        this.cantidadMuertos = cantidadMuertos;
    }

    @NonNull
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(@NonNull String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public String getCoordenadasEpicentro() {
        return coordenadasEpicentro;
    }

    public void setCoordenadasEpicentro(String coordenadasEpicentro) {
        this.coordenadasEpicentro = coordenadasEpicentro;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCantidadMuertos() {
        return cantidadMuertos;
    }

    public void setCantidadMuertos(String cantidadMuertos) {
        this.cantidadMuertos = cantidadMuertos;
    }

    @Override
    public String toString() {
        return "{" +
                 fechaHora + '\'' +
                 nombreDispositivo + '\'' +
                magnitud +
                coordenadasEpicentro + '\'' +
                lugar + '\'' +
                cantidadMuertos + '\'' +
                '}';
    }
}
