package com.dam.proyectobadt2_danielfernandez;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
    CheckBox cbPais;
    CheckBox cbMes;
    CheckBox cbAno;
    PaisesAfectadosDao paisesAfectadosDao;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.filtro, null);


        spnMes = v.findViewById(R.id.spnMes);
        etAno = v.findViewById(R.id.etAno);
        spnPais = v.findViewById(R.id.spnPais);
        cbPais = v.findViewById(R.id.chkPais);
        cbMes = v.findViewById(R.id.chkMes);
        cbAno = v.findViewById(R.id.chkAno);
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
                        String mes = "";
                        String ano = "";
                        String pais = "";
                        //TODO: Validar si el año introducido no supera el año actual

                        //Dependiendo de los checkbox seleccionados se envian los datos al activity atraves del interface
                        if (cbPais.isChecked() && cbMes.isChecked() && cbAno.isChecked()) {
                            listener.onAceptarDatosListenerMesAnoPais(spnMes.getSelectedItem().toString(), etAno.getText().toString(), spnPais.getSelectedItem().toString());

                        }else if (cbAno.isChecked() && cbMes.isChecked()) {
                            listener.onAceptarDatosListenerMesAno(spnMes.getSelectedItem().toString(), etAno.getText().toString());

                        }else if (cbMes.isChecked()) {
                            listener.onAceptarDatosListenerMes(spnMes.getSelectedItem().toString());

                        }else if (cbAno.isChecked()) {
                            listener.onAceptarDatosListenerAno(etAno.getText().toString());

                        }else if (cbPais.isChecked()) {
                            listener.onAceptarDatosListenerPais(spnPais.getSelectedItem().toString());

                        }else if (cbAno.isChecked() && cbPais.isChecked()) {
                            listener.onAceptarDatosListenerAnoPais(etAno.getText().toString(), spnPais.getSelectedItem().toString());
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
