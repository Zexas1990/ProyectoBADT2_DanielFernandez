package com.dam.proyectobadt2_danielfernandez;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FiltroDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.filtro, null);

        // findViewByID de los botones y el textview

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        //metcosas
        AlertDialog dialog = builder.create();
        return dialog;
    }

}
