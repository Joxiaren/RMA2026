package com.example.vezbe2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView textViewUsername = findViewById(R.id.textViewUsername);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewSurname = findViewById(R.id.textViewSurname);
        TextView textViewEmail = findViewById(R.id.textViewEmail);

        Bundle previousBundle = getIntent().getExtras();

        textViewUsername.setText(previousBundle.getString("username"));
        textViewName.setText(previousBundle.getString("name"));
        textViewSurname.setText(previousBundle.getString("surname"));
        textViewEmail.setText(previousBundle.getString("email"));

        EditText editTextConfirm = findViewById(R.id.editTextConfirm);

        Button buttonRegister = findViewById(R.id.buttonRegister3);
        Button buttonOdustani = findViewById(R.id.buttonOdustani3);

        buttonRegister.setOnClickListener(v -> {
            String confirmPassword = editTextConfirm.getText().toString();

            if(confirmPassword.isBlank() || !confirmPassword.equals(previousBundle.getString("password"))){
                Toast.makeText(getApplicationContext(), "Niste unijeli dobru lozinku", Toast.LENGTH_LONG).show();
            }
            else{
                Intent i = new Intent(getApplicationContext(), Registration4Activity.class);
                startActivity(i);
                finish();
            }

        });

        buttonOdustani.setOnClickListener(v -> {
            finish();
        });
    }
}