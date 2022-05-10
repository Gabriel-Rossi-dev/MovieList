package com.cursoandroid.teste.recycler_view.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.teste.recycler_view.R;
import com.cursoandroid.teste.recycler_view.activity.MainActivity;
import com.cursoandroid.teste.recycler_view.activity.model.Movie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> movieList;


    public Adapter(List<Movie> list) {

        this.movieList = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.gender.setText(movie.getGender());
        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

      TextView title;
      TextView gender;
      TextView year;


      public MyViewHolder(@NonNull View itemView) {
          super(itemView);

          title = itemView.findViewById(R.id.textTitle);
          gender = itemView.findViewById(R.id.textGender);
          year = itemView.findViewById(R.id.textYear);

      }
  }

}
