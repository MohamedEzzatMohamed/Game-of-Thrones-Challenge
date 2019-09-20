package com.example.gameofthroneschallenge.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gameofthroneschallenge.Activities.MainActivity;
import com.example.gameofthroneschallenge.Adapters.HousesListAdapter;
import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;
import com.example.gameofthroneschallenge.ViewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class GoTHousesListFragment extends Fragment {

    HousesListAdapter adapter;
    RecyclerView houses_recyclerView;
    MainViewModel viewModel;
    public List<GoTData> goTData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_got_houses_list, container, false);
        houses_recyclerView = view.findViewById(R.id.houses_recyclerView);
        houses_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        goTData = new ArrayList<>();
        viewModel.fetch().observe(this, new Observer<List<GoTData>>() {
            @Override
            public void onChanged(@Nullable List<GoTData> goT) {
                goTData = goT;
                adapter = new HousesListAdapter(getContext(), goTData);
                houses_recyclerView.setAdapter(adapter);
            }
        });
        return view;
    }
}
