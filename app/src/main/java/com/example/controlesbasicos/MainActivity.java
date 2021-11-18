package com.example.controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // Declaracion de controles
    ToggleButton tbApagado;
    Switch swApagado;
    Spinner spBasico;
    RadioButton rbMaculino, rbFemenino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Escucha de controles
        tbApagado = findViewById(R.id.tbApagado);
        swApagado = findViewById(R.id.swApagado);
        spBasico = findViewById(R.id.spBasico);

        // Cargar datos al Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Paises, android.R.layout.simple_spinner_dropdown_item);
        spBasico.setAdapter(adapter);
        rbMaculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        
        tbApagado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbApagado.isChecked())
                    Toast.makeText(MainActivity.this, "Presiono Prendido", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Presiono Apagado", Toast.LENGTH_SHORT).show();
            }
        });

        swApagado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swApagado.isChecked())
                    Toast.makeText(MainActivity.this, "Presiono Prendido", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Presiono Apagado", Toast.LENGTH_SHORT).show();
            }
        });

        rbMaculino.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Seleccion Masculino", Toast.LENGTH_SHORT).show();
            }
        });

        rbFemenino.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Seleccion Femenino", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento que maneja los items dentro de una lista
        spBasico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Posicion " + String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "No se selecciono nada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}