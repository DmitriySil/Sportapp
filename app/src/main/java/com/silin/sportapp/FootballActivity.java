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

public class FootballActivity extends AppCompatActivity {

    private ScrollView rules;
    private LinearLayout players;
    private LinearLayout gallery;
    private RecyclerView recycler1,recycler2;

    String[] strings1,strings2;
    int[] playerImages = {R.drawable.lewan,R.drawable.ronaldo,R.drawable.messi,R.drawable.brunu,R.drawable.mbappe
            ,R.drawable.holland,R.drawable.neymar,R.drawable.ruven,R.drawable.salah,R.drawable.diash};
    int[] galleryImages = {R.drawable.football_1,R.drawable.football_2,R.drawable.football_14,R.drawable.football_5,
            R.drawable.football_6,R.drawable.football_7,R.drawable.football_8,R.drawable.football_9,R.drawable.football_10,
            R.drawable.football_11,R.drawable.football_12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rules = (ScrollView) findViewById(R.id.football_scroll_rules);
        players = (LinearLayout) findViewById(R.id.football_layout_players);
        gallery = (LinearLayout) findViewById(R.id.football_layout_gallery);
        recycler1 = findViewById(R.id.football_recycler_1);
        recycler2 = findViewById(R.id.football_recycler_2);

        strings1 = getResources().getStringArray(R.array.football_players);
        strings2 = getResources().getStringArray(R.array.football_description);

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
                        Intent intent = new Intent(FootballActivity.this,MenuActivity.class);
                        startActivity(intent);finish();
                    }
                }
                return true;
            }
        });


    }
}

