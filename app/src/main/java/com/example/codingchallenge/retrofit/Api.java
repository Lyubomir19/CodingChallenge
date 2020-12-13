package com.example.codingchallenge.retrofit;

import com.example.codingchallenge.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.github.com/orgs/square/";

    @GET("repos")
    Call<List<Repo>> getRepos();
}
