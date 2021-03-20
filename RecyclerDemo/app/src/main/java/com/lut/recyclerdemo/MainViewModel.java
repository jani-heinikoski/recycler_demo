package com.lut.recyclerdemo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

/*
* The ViewModel class allows data to survive configuration changes such as screen rotations.
* */

public class MainViewModel extends ViewModel {
    private final ArrayList<String> movieNames = new ArrayList<>();

    public ArrayList<String> getMovieNames() {
        return movieNames;
    }

    public void setMovieNames(@NonNull ArrayList<String> movieNames) {
        // Does NOT change the ArrayList's address in memory but changes its contents
        this.movieNames.clear();
        this.movieNames.addAll(movieNames);
    }
}
