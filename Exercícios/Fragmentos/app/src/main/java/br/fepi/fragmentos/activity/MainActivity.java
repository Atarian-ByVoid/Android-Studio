package br.fepi.fragmentos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import br.fepi.fragmentos.R;
import br.fepi.fragmentos.fragmentos.ContatosFragment;
import br.fepi.fragmentos.fragmentos.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;
    private Button btnConversas, btnContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        btnConversas = findViewById(R.id.buttonConversas);
        btnContatos = findViewById(R.id.buttonContatos);

        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();

        //configurar o layout do fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //configurar o layout do fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //configurar o layout do fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });
    }
}