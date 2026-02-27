package com.example.vezbe2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button buttonOdustani = findViewById(R.id.buttonOdustani);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        EditText editTextIme = findViewById(R.id.editTextIme);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        buttonRegister.setOnClickListener(v -> {
            if(editTextIme.getText().toString().isBlank() ||
               editTextPassword.getText().toString().isBlank()){
                Toast.makeText(getApplicationContext(), "Niste unijeli sve podatke", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Unijeli ste podatke " + editTextIme.getText().toString() + " " + editTextPassword.getText().toString(), Toast.LENGTH_LONG).show();

                Bundle b = new Bundle();
                b.putString("username", editTextIme.getText().toString());
                b.putString("password", editTextPassword.getText().toString());

                Intent i = new Intent(getApplicationContext(), Registration2Activity.class);
                i.putExtras(b);

                startActivity(i);
                finish();
            }


        });

        buttonOdustani.setOnClickListener(v -> {
            finish();
        });
    }
}