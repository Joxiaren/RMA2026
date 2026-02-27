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

public class Registration2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle previousBundle = getIntent().getExtras();

        Button buttonOdustani = findViewById(R.id.buttonOdustani2);
        Button buttonRegister = findViewById(R.id.buttonRegister2);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPrezime = findViewById(R.id.editTextPrezime);
        EditText editTextEmail = findViewById(R.id.editTextEmail);

        buttonRegister.setOnClickListener(v -> {
            if(editTextName.getText().toString().isBlank() ||
               editTextPrezime.getText().toString().isBlank() ||
               editTextEmail.getText().toString().isBlank()){
                Toast.makeText(getApplicationContext(), "Niste unijeli sve podatke", Toast.LENGTH_LONG).show();
            }
            else{

                Bundle b = new Bundle();

                b.putString("name", editTextName.getText().toString());
                b.putString("surname", editTextPrezime.getText().toString());
                b.putString("email", editTextEmail.getText().toString());

                Intent i = new Intent(getApplicationContext(), Registration3Activity.class);
                i.putExtras(b);
                i.putExtras(previousBundle);

                startActivity(i);
                finish();
            }
        });

        buttonOdustani.setOnClickListener(v -> {
            finish();
        });
    }
}