package com.example.sortearmoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;



public class telaSorteio extends AppCompatActivity {

   private ImageView imageMoeda;
   private ImageButton botaoVoltar;
   private ImageButton botaoResult;
   private int num;
   Bundle saida;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sorteio);
        imageMoeda = findViewById(R.id.gif_moeda);
        botaoVoltar = findViewById(R.id.bnt_voltar);
        botaoResult = findViewById(R.id.bnt_result);
        Glide.with( this).load(R.drawable.moeda).into(imageMoeda);
        saida = getIntent().getExtras();


        String nomeRecebido = saida.getString("nome");
        Toast.makeText(this, "Boa sorte: "+nomeRecebido, Toast.LENGTH_LONG).show();

    }

    public void verResultado (View view ){

        Bundle saida = getIntent().getExtras();
        int num = saida.getInt("numero");

        if(num == 0){
            Glide.with( this).load(R.drawable.moeda_cara).into(imageMoeda);
        }else{
            Glide.with( this).load(R.drawable.moeda_coroa).into(imageMoeda);
        }

        botaoResult.setVisibility(View.INVISIBLE);
        botaoVoltar.setVisibility(View.VISIBLE);

    }
    public void voltar (View view){
        finish();


    }
}