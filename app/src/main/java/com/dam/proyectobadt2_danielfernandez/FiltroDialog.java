package com.dam.proyectobadt2_danielfernandez;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FiltroDialog extends DialogFragment {

    Spinner spnMes;
    EditText etAño;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.filtro, null);

        // findViewByID de los botones y el textview
        spnMes = v.findViewById(R.id.spnMes);
        etAño = v.findViewById(R.id.etAño);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);




        //metcosas
        AlertDialog dialog = builder.create();
        return dialog;
    }

}
