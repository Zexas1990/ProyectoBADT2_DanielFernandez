package com.dam.proyectobadt2_danielfernandez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectobadt2_danielfernandez.entity.Terremoto;

import java.util.ArrayList;

public class TerremotoAdapter extends RecyclerView.Adapter<TerremotoAdapter.TerremotoVH> {
    private ArrayList<Terremoto> datos;

    public TerremotoAdapter(ArrayList<Terremoto> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public TerremotoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.terremoto_layout, parent, false);
        return new TerremotoVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotoVH holder, int position) {
        holder.bindTerremoto(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }



    public static class TerremotoVH extends RecyclerView.ViewHolder {
        TextView tvNombre;
        TextView tvMagnitud;
        TextView tvFecha;
        TextView tvCordenadas;
        TextView tvMuertos;
        TextView tvLugar;


        public TerremotoVH(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvMagnitud = itemView.findViewById(R.id.tvMagnitud);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvCordenadas = itemView.findViewById(R.id.tvCordenadas);
            tvMuertos = itemView.findViewById(R.id.tvNumMuertos);
            tvLugar = itemView.findViewById(R.id.tvLugar);



        }
        //Metodo para enlazar los datos del terremoto con el layout
        public void bindTerremoto(Terremoto terremoto){
            tvNombre.setText(terremoto.getNombre());
            tvMagnitud.setText(String.valueOf(terremoto.getMagnitud()));
            tvFecha.setText(terremoto.getFecha());
            tvCordenadas.setText(terremoto.getCordenadas());
            tvMuertos.setText(terremoto.getMuertos());
            tvMuertos.append("\uD83D\uDC80");
            tvLugar.setText(terremoto.getLugar());
        }

    }

        public void setDatos(ArrayList<Terremoto> datos) {
        this.datos = datos;
        notifyDataSetChanged();
        }

}
