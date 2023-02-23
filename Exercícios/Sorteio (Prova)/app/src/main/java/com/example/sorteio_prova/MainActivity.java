package com.example.sorteio_prova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void sortear(View view){
            TextView texto = findViewById(R.id.txt_numero);
            //sortear um número de 0 a 10
            int x = new Random().nextInt(100)+1 ;
            texto.setText( ""+ x);

        }

    }
