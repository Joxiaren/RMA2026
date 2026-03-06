package com.example.vjezbe3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vjezbe3.model.Contact;

import java.util.ArrayList;

public class ContactEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Bundle b = new Bundle();
        Intent i = new Intent(this, MainActivity.class);

        ArrayList<Contact> contacts = (ArrayList<Contact>) getIntent().getSerializableExtra("contacts");
        String mode = getIntent().getStringExtra("mode");

        EditText editTextIme = findViewById(R.id.editTextIme);
        EditText editTextPrezime = findViewById(R.id.editTextPrezime);
        EditText editTextTel = findViewById(R.id.editTextTel);
        EditText editTextSkype = findViewById(R.id.editTextSkype);

        Button buttonConfirm = findViewById(R.id.buttonConfirm);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        if(mode.equals("edit")){
            String id = getIntent().getStringExtra("contactId");
            Contact contact = contacts.stream().filter( c -> c.getSkypeId().equals(id)).findFirst().get();
            int index = contacts.indexOf(contact);

            editTextIme.setText(contact.getIme());
            editTextPrezime.setText(contact.getPrezime());
            editTextTel.setText(contact.getTel());
            editTextSkype.setText(contact.getSkypeId());

            buttonConfirm.setOnClickListener(v ->{
                contact.setIme(editTextIme.getText().toString());
                contact.setPrezime(editTextPrezime.getText().toString());
                contact.setTel(editTextTel.getText().toString());
                contact.setSkypeId(editTextSkype.getText().toString());

                contacts.set(index, contact);

                b.putSerializable("contacts", contacts);
                i.putExtras(b);

                startActivity(i);
                finish();
            });

        }
        else{
            buttonConfirm.setOnClickListener(v-> {
                Contact contact = new Contact(
                        editTextIme.getText().toString(),
                        editTextPrezime.getText().toString(),
                        editTextTel.getText().toString(),
                        editTextSkype.getText().toString()
                );

                contacts.add(contact);

                b.putSerializable("contacts", contacts);
                i.putExtras(b);

                startActivity(i);
                finish();
            });
        }

        buttonCancel.setOnClickListener(v -> {
            b.putSerializable("contacts", contacts);
            i.putExtras(b);

            startActivity(i);
            finish();
        });
    }
}