package com.example.myapplication.zadaci;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class primer1 extends Fragment {

    public primer1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_primer1, container, false);

        EditText editTextIme = view.findViewById(R.id.editTextIme);
        EditText editTextPrezime = view.findViewById(R.id.editTextPrezime);
        Button buttonRegistracija = view.findViewById(R.id.buttonRegistracija);
        TextView labelPoruka = view.findViewById(R.id.labelPoruka);

        buttonRegistracija.setOnClickListener(v -> {
            labelPoruka.setText(String.format("Registracija izvrsena za %s %s", editTextIme.getText().toString(), editTextPrezime.getText().toString()));
        });

        return view;
    }
}