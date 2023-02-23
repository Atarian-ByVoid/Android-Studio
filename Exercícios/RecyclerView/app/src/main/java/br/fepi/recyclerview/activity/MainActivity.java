package br.fepi.recyclerview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.fepi.recyclerview.R;
import br.fepi.recyclerview.RecyclerItemClickListener;
import br.fepi.recyclerview.adapter.Adapter;
import br.fepi.recyclerview.models.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listagem de filmes
        criarFilmes();

        recyclerView = findViewById(R.id.recyclerView);

        //configurar adapter
        Adapter adapter = new Adapter(filmes);

        //configurar layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = filmes.get(position);

                        Toast.makeText(getApplicationContext(), "Item pressionado: "+ filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = filmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click longo: "+filme.getTitulo(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                })
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha", "Aventura", "2017");
        this.filmes.add(filme);

        filme = new Filme("A Era do Gelo: As Aventuras de Buck", "Aventura", "2022");
        this.filmes.add(filme);

        filme = new Filme("Hotel Transilvânia: Transformonstrão ", "Aventura", "2022");
        this.filmes.add(filme);

        filme = new Filme("Homem-aranha: Sem volta para casa", "Aventura", "2021");
        this.filmes.add(filme);

        filme = new Filme("Godzilla vs. Kong", "Ficção", "2021");
        this.filmes.add(filme);

        filme = new Filme("The Old Guard ", "Ação", "2020");
        this.filmes.add(filme);

        filme = new Filme("A Guerra do Amanhã", "Ação", "2020");
        this.filmes.add(filme);
    }
}