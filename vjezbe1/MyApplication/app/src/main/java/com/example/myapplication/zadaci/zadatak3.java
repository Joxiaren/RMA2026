package com.example.myapplication.zadaci;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class zadatak3 extends Fragment {


    public zadatak3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_zadatak3, container, false);

        TableLayout tablePredmeti = view.findViewById(R.id.tablePredmeti);

        List<String> predmeti = Arrays.asList("RMA", "ISA", "KWA", "RP");
        List<String> obaveze = Arrays.asList("K1", "K2", "Ispit");


        TableRow header = new TableRow(getActivity());
        for (String predmet : predmeti) {
            TextView headerText = new TextView(getActivity());
            headerText.setText(predmet);

            header.addView(headerText);
        }
        tablePredmeti.addView(header);

        Random r = new Random();
        for (String obaveza : obaveze){
            TableRow tableRow = new TableRow(getActivity());

            for(String predmet : predmeti){
                Button btn = new Button(getActivity());
                btn.setText(obaveza);
                btn.setOnClickListener(v -> {
                    Toast.makeText(getActivity(), String.format("%s %s: %d",predmet, obaveza, r.nextInt(101)), Toast.LENGTH_SHORT).show();
                });

                tableRow.addView(btn);
            }

            tablePredmeti.addView(tableRow);
        }

        return view;
    }
}