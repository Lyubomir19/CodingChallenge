package com.example.codingchallenge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.codingchallenge.R;
import com.example.codingchallenge.adapter.RepoAdapter;
import com.example.codingchallenge.viewmodel.RepoViewModel;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RepoAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RepoViewModel model = ViewModelProviders.of(this).get(RepoViewModel.class);

        model.getRepos().observe(this, repos -> {
            adapter = new RepoAdapter(MainActivity.this, repos);
            recyclerView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        });

    }
}