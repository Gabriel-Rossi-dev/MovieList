package com.cursoandroid.teste.recycler_view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursoandroid.teste.recycler_view.R;
import com.cursoandroid.teste.recycler_view.activity.adapter.Adapter;
import com.cursoandroid.teste.recycler_view.activity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.createMovies();

        Adapter adapter = new Adapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Movie movie = movieList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click curto: " + movie.getTitle(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Movie movie = movieList.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo: " + movie.getGender(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

   public void createMovies(){


       Movie movie = new Movie("Homem Aranha - De volta ao lar ", "Ação", "2020");
       this.movieList.add(movie);

       movie =  new Movie("A Nova Onda do Imperador", "Comédia ", "2000");
       this.movieList.add(movie);

       movie = new Movie("Nem que a vaca tussa", "Comédia", "2004");
       this.movieList.add(movie);

       movie = new Movie("Interestelar", "Aventura", "2014");
       this.movieList.add(movie);

       movie = new Movie("A Origem", "Ficção Científica", "2010");
       this.movieList.add(movie);

       movie = new Movie("It, A Coisa", "Terror", "2017");
       this.movieList.add(movie);

       movie = new Movie("A múmia", "Terror", "2017");
       this.movieList.add(movie);

       movie = new Movie("A bela e a Fera", "Romance", "2017");
       this.movieList.add(movie);

       movie = new Movie("Meu malvado favorito", "Comédia", "2017");
       this.movieList.add(movie);

       movie = new Movie("Carros 3", "Comédia", "2017");
       this.movieList.add(movie);

   }
}
