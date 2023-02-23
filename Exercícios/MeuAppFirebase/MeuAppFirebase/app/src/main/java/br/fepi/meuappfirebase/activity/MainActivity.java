package br.fepi.meuappfirebase.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.fepi.meuappfirebase.R;
import br.fepi.meuappfirebase.adapter.Adapter;
import br.fepi.meuappfirebase.listener.RecyclerItemClickListener;
import br.fepi.meuappfirebase.model.Filme;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();
    private DatabaseReference referenciaFirebase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        configurarRecyclerView();

        //Buscar filmes cadastrados no Firebase
        baixarFilmesFirebase();

        //adiciona ouvinte de evento para cada iten da lista  (listener)
        adicionarOuvinteItem();

    }  // FIM DO ONCREATE

    private void configurarRecyclerView() {
        //configurar layout manager do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        Adapter adapter = new Adapter(filmes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayout.VERTICAL));
    }

    private void baixarFilmesFirebase() {

        referenciaFirebase.child("filmes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                filmes.clear();  //apaga todos itens da lista para adicionar novamente depois
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Filme f = ds.getValue(Filme.class);
                    filmes.add(f);
                }
                //configurar adapter com a lista atualizada com os dados do firebases
                Adapter adapter = new Adapter(filmes);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    } //FIM DO MÉTODO baixarFilmesFirebase

    private void adicionarOuvinteItem() {
        //PARA UTILIZAR EVENTOS DE CLICK EM CADA ITEM UTILIZE O CÓDIGO ABAIXO
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = filmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item pressionado: "+ filme.getTitulo(), Toast.LENGTH_SHORT).show();

                        //poderia implementar aqui a ação para abrir uma outra tela com os detalhes do filme, por exemplo
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

    /***NÃO SERÁ MAIS UTILIZADO o método criarFilmes
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
    }*/

}  //fim da classe MainActivity