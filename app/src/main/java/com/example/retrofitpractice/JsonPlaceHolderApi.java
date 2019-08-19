package com.example.retrofitpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("Vy2abloQD")
    Call<List<Post>> getPosts();
}
