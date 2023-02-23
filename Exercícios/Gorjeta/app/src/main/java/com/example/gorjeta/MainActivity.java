package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private SeekBar seekBar;
        private TextView textValor;
        private EditText conta;
        private EditText totalGorjeta;
        private EditText total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textValor = findViewById(R.id.textValor);
        conta = findViewById(R.id.valorConta);
        totalGorjeta = findViewById(R.id.valorGorjeta);
        total = findViewById(R.id.valorTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textValor.setText("Porcentagem :"+ i);

                double  c = Double.parseDouble(conta.getText().toString());

                double vg = c * i / 100;
                totalGorjeta.setText("R$"+ vg);

                double t =  c + vg;
                total.setText("R$" + t);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}