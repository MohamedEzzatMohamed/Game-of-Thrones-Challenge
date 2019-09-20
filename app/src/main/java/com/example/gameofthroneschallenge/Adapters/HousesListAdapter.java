package com.example.gameofthroneschallenge.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameofthroneschallenge.Activities.CharactersActivity;
import com.example.gameofthroneschallenge.Activities.DetailActivity;
import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class HousesListAdapter extends RecyclerView.Adapter<HousesListAdapter.ViewHolder> {

    public Context context;
    public List<GoTData> goTData;


    public HousesListAdapter(Context context, List<GoTData> goTData) {
        this.context = context;
        this.goTData = goTData;

    }

    @Override
    public HousesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemlayout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.house_item, viewGroup, false);
        ViewHolder viewHolder = new HousesListAdapter.ViewHolder(itemlayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HousesListAdapter.ViewHolder viewHolder, int i) {
        final GoTData in = goTData.get(i);

        if(in.getHouseImageUrl().equals("")){
            return;
        }
        Picasso.get().load(in.getHouseImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(viewHolder.houses_imageView);

        viewHolder.houses_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CharactersActivity.class);
                Bundle b = new Bundle();
                b.putString("id", in.getHouseId());
                b.putSerializable("data", (Serializable) goTData);
                intent.putExtras(b);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return goTData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView houses_imageView;
        CardView houses_cardView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            houses_imageView = itemView.findViewById(R.id.houses_imageView);
            houses_cardView = itemView.findViewById(R.id.houses_cardView);

        }
    }

}
