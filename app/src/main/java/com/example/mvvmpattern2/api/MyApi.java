package com.example.mvvmpattern2.api;

import com.example.mvvmpattern2.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("movies")
    Call<List<Movie>> getMovies();

}
