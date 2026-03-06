package com.example.vjezbe3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vjezbe3.model.Contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private ViewGroup scrollContent;
    private final List<Integer> colors = List.of(Color.argb(255, 25, 0, 40), Color.argb(255, 7, 1, 49));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Serializable contactsExtra = getIntent().getSerializableExtra("contacts");

        if(contactsExtra == null){
            contacts.add(new Contact("Jovan", "Stoilkovic", "+2190831", "Joxiaren"));
            contacts.add(new Contact("Dusan", "Krstic", "1283124412", "Sandu"));
            contacts.add(new Contact("Gojko", "Dikic", "21387941", "Shadow"));
            contacts.add(new Contact("Milan", "Milankovic", "41356712", "Miki"));
            contacts.add(new Contact("Dragan", "Dragankovic", "987912824", "Koord"));
            contacts.add(new Contact("Mihajlo", "Sincevic", "89712124", "Leprox"));
            contacts.add(new Contact("Jelena", "Grujic", "0668093237", "Lena"));
        }
        else{
            contacts = (ArrayList<Contact>) contactsExtra;
        }

        scrollContent = (ViewGroup) findViewById(R.id.scrollContent);
        LayoutInflater inflater = LayoutInflater.from(this);

        int index = 0;

        for(Contact contact: contacts){

            View view = inflater.inflate(R.layout.contact_view, scrollContent, false);

            view.setOnClickListener(v -> {
                Bundle b = new Bundle();
                b.putSerializable("contacts", contacts);
                b.putString("contactId", contact.getSkypeId());
                b.putString("mode", "edit");

                Intent i = new Intent(this, ContactEditActivity.class);
                i.putExtras(b);

                startActivity(i);
                finish();
            });

            view.setBackgroundColor(colors.get(index % 2));

            TextView labelIme = view.findViewById(R.id.labelIme);
            TextView labelPrezime = view.findViewById(R.id.labelPrezime);
            TextView labelTel = view.findViewById(R.id.labelTel);
            TextView labelSkype = view.findViewById(R.id.labelSkype);
            ImageView imageView = view.findViewById(R.id.imageView);
            Button buttonDelete = view.findViewById(R.id.buttonDelete);

            labelIme.setText(contact.getIme());
            labelPrezime.setText(contact.getPrezime());
            labelTel.setText(contact.getTel());
            labelSkype.setText(contact.getSkypeId());
            imageView.setImageResource(R.drawable.cat);

            buttonDelete.setOnClickListener(v -> {
                contacts.remove(contact);
                scrollContent.removeView(view);
                this.recolor();
            });

            scrollContent.addView(view);

            index++;
        }

        Button buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(v -> {
            Bundle b = new Bundle();
            b.putSerializable("contacts", contacts);
            b.putString("mode", "add");

            Intent i = new Intent(this, ContactEditActivity.class);
            i.putExtras(b);

            startActivity(i);
            finish();
        });

    }
    private void recolor(){
        int viewCount = scrollContent.getChildCount();
        View v;

        for(int j = 0; j < viewCount; j++) {
            v = scrollContent.getChildAt(j);
            v.setBackgroundColor(colors.get(j % 2));
        }
    }
}