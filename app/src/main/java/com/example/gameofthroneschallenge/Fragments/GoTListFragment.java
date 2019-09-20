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
import com.example.gameofthroneschallenge.Adapters.CharactersListAdapter;
import com.example.gameofthroneschallenge.Adapters.HousesListAdapter;
import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;
import com.example.gameofthroneschallenge.ViewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class GoTListFragment extends Fragment {

    CharactersListAdapter adapter;
    RecyclerView characters_recyclerView;
    MainViewModel viewModel;
    public List<GoTData> goTData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_got_list, container, false);
        characters_recyclerView = view.findViewById(R.id.characters_recyclerView);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        goTData = new ArrayList<>();
        viewModel.fetch().observe(this, new Observer<List<GoTData>>() {
            @Override
            public void onChanged(@Nullable List<GoTData> goT) {
                goTData = goT;
                adapter = new CharactersListAdapter(getContext(), goTData);
                characters_recyclerView.setAdapter(adapter);
            }
        });
       characters_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
