package com.example.gameofthroneschallenge.Adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gameofthroneschallenge.Fragments.GoTHousesListFragment;
import com.example.gameofthroneschallenge.Fragments.GoTListFragment;
import com.example.gameofthroneschallenge.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;
    Context context;
    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragments = new ArrayList<>();
        GoTListFragment goTListFragment = new GoTListFragment();
        GoTHousesListFragment goTHousesListFragment = new GoTHousesListFragment();
        fragments.add(goTListFragment);
        fragments.add(goTHousesListFragment);

    }



    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.characters);
            case 1:
                return context.getString(R.string.houses);
            default:
                return " ";
        }
    }
}
