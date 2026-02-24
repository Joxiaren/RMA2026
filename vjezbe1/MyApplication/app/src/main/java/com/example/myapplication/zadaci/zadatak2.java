package com.example.myapplication.zadaci;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myapplication.R;

public class zadatak2 extends Fragment {

    public zadatak2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zadatak2, container, false);

        EditText celzijus = view.findViewById(R.id.editNumberCelzijus);
        EditText kelvin = view.findViewById(R.id.editNumberKelvin);


        celzijus.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                String celzijusString = celzijus.getText().toString();

                if(celzijusString.isBlank()){
                    kelvin.setText("");
                    return;
                }

                double celzijusValue = Double.parseDouble(celzijus.getText().toString());
                celzijusValue += 273;
                kelvin.setText(Double.toString(celzijusValue));
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        });

        return view;
    }
}