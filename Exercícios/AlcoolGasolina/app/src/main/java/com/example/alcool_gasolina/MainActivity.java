package com.example.alcool_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textoAlcool;
    private EditText textoGasolina;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoAlcool = findViewById(R.id.insert_alccol);
        textoGasolina = findViewById(R.id.insert_gasolina);
        textoResultado = findViewById(R.id.txt_result);


    }

    public void calcular (View view){
        String alcool = textoAlcool.getText().toString();
        String gasolina = textoGasolina.getText().toString();

        float valoAlcool = Float.parseFloat(alcool);
        float valoGasolina = Float.parseFloat(gasolina);

        if (valoAlcool < 0.7* valoGasolina){

    textoResultado.setText("USE ALCOOL");
        }else{
            textoResultado.setText("USE GASOLINA");

        }






    }



}