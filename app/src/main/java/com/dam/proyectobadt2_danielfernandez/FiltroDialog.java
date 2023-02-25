package com.dam.proyectobadt2_danielfernandez;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    MainActivity mainActivity;
    String mes = null;
    String ano = null;
    String pais = null;

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


                        //Validar si el año no supera el 2023
                        if (cbAno.isChecked() && (Integer.parseInt(etAno.getText().toString()) > 2023)) {
                            Toast.makeText(getActivity(), "El año introducido no es válido", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        //TODO: Validar si el año no te lo dan

                        if(cbMes.isChecked()){
                            mes = spnMes.getSelectedItem().toString();
                        }
                        if(cbAno.isChecked()){
                            ano = etAno.getText().toString();


                        }
                        if(cbPais.isChecked()){
                            pais = spnPais.getSelectedItem().toString();
                        }

                        //Dependiendo de los checkbox seleccionados se envian los datos al activity atraves del interface
                        listener.onAceptarDatosListenerMesAnoPais(mes, ano, pais);




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

    public void onAttach(@NonNull android.app.Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnDatosListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDatosListener");
        }
    }

    @Override
    public void onDetach() {
        if(listener != null){
            listener = null;
        }
        super.onDetach();
    }

}
