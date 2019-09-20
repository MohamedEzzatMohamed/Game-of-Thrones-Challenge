package com.example.gameofthroneschallenge.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameofthroneschallenge.Activities.DetailActivity;
import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharactersListAdapter extends RecyclerView.Adapter<CharactersListAdapter.ViewHolder> {

    public Context context;
    public List<GoTData> goTData;


    public CharactersListAdapter(Context context, List<GoTData> goTData) {
        this.context = context;
        this.goTData = goTData;

    }

    @Override
    public CharactersListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemlayout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.character_item, viewGroup, false);
        ViewHolder viewHolder = new CharactersListAdapter.ViewHolder(itemlayout);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersListAdapter.ViewHolder viewHolder, int i) {
        final GoTData in = goTData.get(i);

        viewHolder.characters_name_textView.setText(in.getName());
        Picasso.get().load(in.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(viewHolder.character_imageView);

        viewHolder.characters_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("detail", in);
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
        TextView characters_name_textView;
        CardView characters_cardView;
        ImageView character_imageView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            characters_name_textView = itemView.findViewById(R.id.characters_name_textView);
            characters_cardView = itemView.findViewById(R.id.characters_cardView);
            character_imageView = itemView.findViewById(R.id.character_imageView);

        }
    }

}
