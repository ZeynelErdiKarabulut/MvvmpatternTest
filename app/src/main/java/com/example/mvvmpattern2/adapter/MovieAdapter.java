package com.example.mvvmpattern2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmpattern2.R;
import com.example.mvvmpattern2.databinding.MovieItemBinding;
import com.example.mvvmpattern2.model.Movie;

import java.lang.reflect.AnnotatedElement;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private OnItemClickListener listener;
    private List<Movie> movieList;
    private Context context;
    private LayoutInflater layoutInflater;

    public MovieAdapter(List<Movie> movieList,Context context){
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        MovieItemBinding movieItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.movie_item,parent,false);
        return new MovieViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieItemBinding movieItemBinding;

        public MovieViewHolder(@NonNull MovieItemBinding movieItemBinding) {
            super(movieItemBinding.getRoot());
            this.movieItemBinding = movieItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(movieList.get(position));
                    }
                }
            });

        }

        public void setMovie(Movie movie){
            this.movieItemBinding.setMovie(movie);
            movieItemBinding.executePendingBindings();
        }

    }
    public interface OnItemClickListener {
        void onItemClick(Movie note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
