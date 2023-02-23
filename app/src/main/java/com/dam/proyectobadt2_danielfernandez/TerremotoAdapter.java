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
        TextView tvAdapter;


        public TerremotoVH(@NonNull View itemView) {
            super(itemView);
            tvAdapter = itemView.findViewById(R.id.tvAdapter);

        }

        public void bindTerremoto(Terremoto terremoto){
            tvAdapter.setText(terremoto.toString());
        }

    }

        public void setDatos(ArrayList<Terremoto> datos) {
        this.datos = datos;
        notifyDataSetChanged();
        }

}
