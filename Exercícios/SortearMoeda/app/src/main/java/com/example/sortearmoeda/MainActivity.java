package com.example.sortearmoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText textoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar (View view ){
        Intent intent = new Intent(getApplicationContext(),telaSorteio.class);

        textoNome = findViewById(R.id.edit_name);

        int numero = new Random().nextInt(2);
        intent.putExtra("numero", numero);
        intent.putExtra("nome", textoNome.getText().toString());

        startActivity(intent);


    }


}