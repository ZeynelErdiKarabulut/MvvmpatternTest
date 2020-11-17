package com.example.mvvmpattern2.api.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpattern2.api.MyApi;
import com.example.mvvmpattern2.api.MyClient;
import com.example.mvvmpattern2.model.Movie;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private MutableLiveData<List<Movie>> listMutableLiveData = new MutableLiveData<>();
    private List<Movie> movieList = new ArrayList<>();

    public MovieRepository(){

    }

    public MutableLiveData<List<Movie>> getListMutableLiveData(){
        MyApi api= MyClient.getInstance().getMyApi();
        Call<List<Movie>> call=api.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
                if (movieList != null) {
                   listMutableLiveData.setValue(movieList);
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });

       return listMutableLiveData;
    }

}
