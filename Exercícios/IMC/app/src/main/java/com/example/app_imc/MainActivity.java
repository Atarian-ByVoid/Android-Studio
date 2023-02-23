package com.example.app_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
        txtResultado = findViewById(R.id.txtResultado);


    }
    public void calcularImc(View view){
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        double imc = peso/(altura*altura);

        if(imc >=18.5 && imc <=24.99){
            txtResultado.setText("Peso normal, IMC ="+imc);


        }else if (imc >=25 && imc <=25){
            txtResultado.setText("Acima do peso, IMC ="+imc);

        }else if(imc>=30 && imc <=34.99){
            txtResultado.setText("Obesidade I, IMC ="+imc);

        }else if(imc>=35 && imc<=39.99){
            txtResultado.setText("Obesidade II , IMC ="+imc);

        }else if(imc>40){
            txtResultado.setText("Obesidade III , IMC ="+imc);

        }else if(imc <18.5){
            txtResultado.setText("Abaixo do peso, IMC ="+imc);

        }



    }
}