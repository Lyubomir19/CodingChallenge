package com.example.codingchallenge.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codingchallenge.model.Repo;
import com.example.codingchallenge.retrofit.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoViewModel  extends ViewModel {

    private static final String TAG = RepoViewModel.class.getSimpleName();

    private MutableLiveData<List<Repo>> repoList;

    public LiveData<List<Repo>> getRepos() {

        if (repoList == null) {
            repoList = new MutableLiveData<>();
            loadRepos();
        }
        return repoList;
    }

    private void loadRepos () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Repo>> call = api.getRepos();
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    repoList.setValue(response.body());
                    Log.d(TAG, "onResponse: U did it " + response);
                }
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(TAG, "onFailure: Something failed" + t);
            }
        });
    }
}
