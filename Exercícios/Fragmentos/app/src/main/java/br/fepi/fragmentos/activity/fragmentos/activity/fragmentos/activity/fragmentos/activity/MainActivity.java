package br.fepi.fragmentos.activity.fragmentos.activity.fragmentos.activity.fragmentos.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.fepi.fragmentos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);
    }
}