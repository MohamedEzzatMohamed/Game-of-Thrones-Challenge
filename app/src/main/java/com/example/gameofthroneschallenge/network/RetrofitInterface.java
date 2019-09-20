package com.example.gameofthroneschallenge.network;

import com.example.gameofthroneschallenge.Model.GoTData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("characters.json?print=pretty")
    Call<List<GoTData>> getData();
}
