package com.example.mvvmpattern2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmpattern2.api.repository.MovieRepository;
import com.example.mvvmpattern2.model.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MovieViewModel(@NonNull Application application){
        super(application);
        movieRepository = new MovieRepository();
    }

    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getListMutableLiveData();
    }

}
