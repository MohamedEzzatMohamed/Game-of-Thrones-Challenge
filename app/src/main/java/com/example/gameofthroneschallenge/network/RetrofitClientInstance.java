package com.example.gameofthroneschallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(" https://android-challenge-3472e.firebaseio.com/").addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

