package com.lut.recyclerdemo;

import java.util.ArrayList;
import java.util.Locale;

public class APIHandler {
    public static ArrayList<String> fetchMovies(int count) {
        ArrayList<String> movieNames = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            movieNames.add(
                    String.format(Locale.getDefault(), "%s%d", "Movie: ", i)
            );
        }
        return movieNames;
    }
}
