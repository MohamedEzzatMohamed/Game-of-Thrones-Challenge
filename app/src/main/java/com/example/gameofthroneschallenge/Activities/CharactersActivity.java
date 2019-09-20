package com.example.gameofthroneschallenge.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.gameofthroneschallenge.Adapters.CharactersListAdapter;
import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;

import java.util.ArrayList;
import java.util.List;

public class CharactersActivity extends AppCompatActivity {

    CharactersListAdapter adapter;
    RecyclerView characters_house_recyclerView;
    List<GoTData> goTData;
    String houseId;
    List<GoTData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        characters_house_recyclerView = findViewById(R.id.characters_house_recyclerView);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        goTData = new ArrayList<>();
        data = new ArrayList<>();
        houseId = bundle.getString("id");
        goTData = (List<GoTData>) bundle.getSerializable("data");
        getSupportActionBar().setTitle(goTData.get(0).getHouseName());

        filter();
        adapter = new CharactersListAdapter(getApplicationContext(), data);
        characters_house_recyclerView.setAdapter(adapter);
        characters_house_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    void filter() {
        for (int i = 0; i < goTData.size(); i++) {
            if (goTData.get(i).getHouseId().equals(houseId)) {
                data.add(goTData.get(i));
            }
        }
    }
}
