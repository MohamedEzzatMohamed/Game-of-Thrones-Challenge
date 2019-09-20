package com.example.gameofthroneschallenge.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.gameofthroneschallenge.Model.GoTData;
import com.example.gameofthroneschallenge.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView characters_name_textDetail, characters_detail_textDetail;
    ImageView character_imageDetail;
    GoTData goTData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        goTData = (GoTData) bundle.getSerializable("detail");

        getSupportActionBar().setTitle(goTData.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        characters_detail_textDetail = findViewById(R.id.characters_detail_textDetail);
        characters_name_textDetail = findViewById(R.id.characters_name_textDetail);
        characters_name_textDetail.setText(goTData.getName());
        characters_detail_textDetail.setText(goTData.getDescription());
        character_imageDetail = findViewById(R.id.character_imageDetail);

        Picasso.get().load(goTData.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(character_imageDetail);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
