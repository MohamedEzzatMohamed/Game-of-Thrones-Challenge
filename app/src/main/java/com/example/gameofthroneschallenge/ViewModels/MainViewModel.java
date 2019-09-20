package com.example.gameofthroneschallenge.ViewModels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.network.RetrofitClientInstance;
import com.example.gameofthroneschallenge.network.RetrofitInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    RetrofitInterface retrofitInterface;
    public MutableLiveData<List<GoTData>> data;

    public MutableLiveData<List<GoTData>> fetch() {
        if (data == null) {
            data = new MutableLiveData<List<GoTData>>();

        }
        loadData();
        return data;
    }

    private void loadData() {
        retrofitInterface = RetrofitClientInstance.getRetrofit().create(RetrofitInterface.class);
        retrofitInterface.getData().enqueue(new Callback<List<GoTData>>() {
            @Override
            public void onResponse(Call<List<GoTData>> call, Response<List<GoTData>> response) {
                data.setValue(response.body());
                Log.e("Response", "onSuccess");
            }
            @Override
            public void onFailure(Call<List<GoTData>> call, Throwable t) {
                Log.e("Response", "onFailure");
            }
        });
    }
}
