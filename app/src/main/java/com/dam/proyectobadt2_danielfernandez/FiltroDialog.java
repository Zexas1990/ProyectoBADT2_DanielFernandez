package com.dam.proyectobadt2_danielfernandez;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.dam.proyectobadt2_danielfernandez.DB.TerremotosDB;
import com.dam.proyectobadt2_danielfernandez.dao.PaisesAfectadosDao;

public class FiltroDialog extends DialogFragment {

    OnDatosListener listener;
    Spinner spnMes;
    EditText etAno;
    Spinner spnPais;
    PaisesAfectadosDao paisesAfectadosDao;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.filtro, null);


        spnMes = v.findViewById(R.id.spnMes);
        etAno = v.findViewById(R.id.etAño);
        spnPais = v.findViewById(R.id.spnPais);
        paisesAfectadosDao = TerremotosDB.getDatabase(getActivity()).paisesAfectadosDao();


        spnPais.setAdapter(
                new android.widget.ArrayAdapter<>(
                        getActivity(),
                        android.R.layout.simple_spinner_dropdown_item,
                        paisesAfectadosDao.getAllPaises().toArray(new String[0])

                )
        );

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        builder.setTitle("")
                .setPositiveButton(R.string.btn_aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mes = spnMes.getSelectedItem().toString();
                        String ano = etAno.getText().toString();
                        String pais = spnPais.getSelectedItem().toString();

                        if (mes.isEmpty() || ano.isEmpty() || pais.isEmpty()) {

                        } else {
                            // enviar datos al activity atraves del Interface
                            listener.onAceptarDatosListener(mes, ano, pais);

                        }

                    }
                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog ad = builder.create();
                ad.setCancelable(false);





        //metcosas
        AlertDialog dialog = builder.create();
        return dialog;
    }

}
