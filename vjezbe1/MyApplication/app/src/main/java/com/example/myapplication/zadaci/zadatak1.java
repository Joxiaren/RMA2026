package com.example.myapplication.zadaci;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class zadatak1 extends Fragment {

    public zadatak1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zadatak1, container, false);

        EditText text1 = view.findViewById(R.id.editTextText1);
        EditText text2 = view.findViewById(R.id.editTextText2);

        Button zamijeni = view.findViewById(R.id.button);
        Button obrisi = view.findViewById(R.id.button2);

        zamijeni.setOnClickListener(v -> {
            String temp = text1.getText().toString();
            text1.setText(text2.getText().toString());
            text2.setText(temp);
        });

        obrisi.setOnClickListener(v ->{
            text1.setText("");
            text2.setText("");
        });

        return view;
    }
}