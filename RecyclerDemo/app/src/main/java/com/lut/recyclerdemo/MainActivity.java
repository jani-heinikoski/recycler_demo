package com.lut.recyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainViewModel viewModel;
    private MainRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Add following lines to module build.gradle dependencies:
        def lifecycle_version = "2.3.0"
        // ViewModel
        implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
        */
        recyclerView = findViewById(R.id.main_recycler_view);
        // Get the MainViewModel reference
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.setMovieNames(APIHandler.fetchMovies(10));
        // Adapter for the MainRecyclerView
        recyclerAdapter = new MainRecyclerAdapter(viewModel.getMovieNames());
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        // After updating the movies use the next line to update displayed items.
        // Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
    }
}