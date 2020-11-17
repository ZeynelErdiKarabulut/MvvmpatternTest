package com.example.mvvmpattern2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmpattern2.adapter.MovieAdapter;
import com.example.mvvmpattern2.databinding.ActivityMainBinding;
import com.example.mvvmpattern2.model.Movie;
import com.example.mvvmpattern2.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private MovieViewModel movieViewModel;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        recyclerview= activityMainBinding.recyclerView;
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movieList) {
                adapter = new MovieAdapter(movieList,MainActivity.this);
                recyclerview.setAdapter(adapter);
                adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Movie note) {
                        Toast.makeText(MainActivity.this, note.title, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }
}
