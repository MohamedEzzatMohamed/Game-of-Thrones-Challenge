package com.example.gameofthroneschallenge.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.example.gameofthroneschallenge.ViewModels.MainViewModel;
import com.example.gameofthroneschallenge.R;
import com.example.gameofthroneschallenge.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(!viewModel.checkWifi()){
//            Toast.makeText(getApplicationContext(), getText(R.string.no_internet),Toast.LENGTH_SHORT).show();
//            return;
//        }

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        ViewPager home_ViewPager = findViewById(R.id.home_ViewPager);
        home_ViewPager.setAdapter(adapter);
        TabLayout tab_Layout = findViewById(R.id.tab_Layout);
        tab_Layout.setupWithViewPager(home_ViewPager);
    }

}
