package com.example.bazadanychsamochody;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutkaBazyDanych autkaDB;

    List<Samochod> samochodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        autkaDB = AutkaBazyDanych.zwrocBazeDanych(MainActivity.this);
        autkaDB.zwrocAutkaDao().wstawAutko(new Samochod("Opel", "Astra", 2009, 150));
//        autkaDB.zwrocAutkaDao().wstawAutko(new Samochod("Volkswagen", "Golf", 1999, 200));

        EditText marka = findViewById(R.id.marka);
        EditText model = findViewById(R.id.model);
        EditText rocznik = findViewById(R.id.rocznik);
        EditText moc_silnika = findViewById(R.id.mocSilnika);
        Button zatwierdz = findViewById(R.id.zatwierdz);

        ListView listView = findViewById(R.id.listaAut);
        samochodList = autkaDB.zwrocAutkaDao().zwrocWszystkieAutka();
        ArrayAdapter<Samochod> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, samochodList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                autkaDB.zwrocAutkaDao().usunAutko(samochodList.get(i));
                samochodList.remove(i);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Samochod samochod = new Samochod(marka.getText().toString(), model.getText().toString(), Integer.parseInt(rocznik.getText().toString()), Integer.parseInt(moc_silnika.getText().toString()));
                autkaDB.zwrocAutkaDao().wstawAutko(samochod);
                samochodList.add(samochod);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}