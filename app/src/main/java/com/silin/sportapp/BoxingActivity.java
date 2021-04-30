package com.silin.sportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.silin.sportapp.adapter.GalleryAdapter;
import com.silin.sportapp.adapter.PlayerAdapter;

public class BoxingActivity extends AppCompatActivity {

    private ScrollView rules;
    private LinearLayout players;
    private LinearLayout gallery;
    private RecyclerView recycler1,recycler2;

    String[] strings1,strings2;
    int[] playerImages = {R.drawable.joe_luis,R.drawable.muhammad_ali,R.drawable.shugar_ray,R.drawable.jek_jonson
            ,R.drawable.jack_dempsey,R.drawable.mike_tayson,R.drawable.chaves_starshiy,R.drawable.rokki_marchiano,
            R.drawable.henry_armstrong,R.drawable.willy_pep};

    int[] galleryImages = {R.drawable.box_1,R.drawable.box_2,R.drawable.box_3,R.drawable.box_4,
            R.drawable.box_5,R.drawable.box_6,R.drawable.box_7,R.drawable.box_8,R.drawable.box_9,
            R.drawable.box_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rules = (ScrollView) findViewById(R.id.boxing_scroll_rules);
        players = (LinearLayout) findViewById(R.id.boxing_layout_players);
        gallery = (LinearLayout) findViewById(R.id.boxing_layout_gallery);
        recycler1 = findViewById(R.id.boxing_recycler_1);
        recycler2 = findViewById(R.id.boxing_recycler_2);

        strings1 = getResources().getStringArray(R.array.boxers);
        strings2 = getResources().getStringArray(R.array.boxing_description);

        PlayerAdapter playerAdapter = new PlayerAdapter(this,strings1,strings2, playerImages);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this,galleryImages);

        recycler1.setAdapter(playerAdapter);
        recycler1.setLayoutManager(new LinearLayoutManager(this));

        recycler2.setAdapter(galleryAdapter);
        recycler2.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.rules_item:
                                    rules.setVisibility(View.VISIBLE);
                                    players.setVisibility(View.GONE);
                                    gallery.setVisibility(View.GONE);
                                    break;
                    case R.id.players_item:
                                      players.setVisibility(View.VISIBLE);
                                      rules.setVisibility(View.GONE);
                                      gallery.setVisibility(View.GONE);
                                      break;
                    case R.id.gallery_item:
                                      gallery.setVisibility(View.VISIBLE);
                                      players.setVisibility(View.GONE);
                                      rules.setVisibility(View.GONE);
                                      break;
                    case R.id.main_item:{
                        Intent intent = new Intent(BoxingActivity.this,MenuActivity.class);
                        startActivity(intent);finish();
                    }
                }
                return true;
            }
        });
    }
}

