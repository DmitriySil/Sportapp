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

public class TennisActivity extends AppCompatActivity {

    private ScrollView rules;
    private LinearLayout players;
    private LinearLayout gallery;
    private RecyclerView recycler1,recycler2;

    String[] strings1,strings2;
    int[] playerImages = {R.drawable.navratilova,R.drawable.evert,R.drawable.graf,R.drawable.wil_jun,R.drawable.kouly
            ,R.drawable.king,R.drawable.devenport,R.drawable.selesh,R.drawable.wiliams,R.drawable.hings};

    int[] galleryImages = {R.drawable.tennis_1,R.drawable.tennis_2,R.drawable.tennis_3,R.drawable.tennis_4,
            R.drawable.tennis_5,R.drawable.tennis_6,R.drawable.tennis_7,R.drawable.tennis_8,R.drawable.tennis_9,
            R.drawable.tennis_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rules = (ScrollView) findViewById(R.id.tennis_scroll_rules);
        players = (LinearLayout) findViewById(R.id.tennis_layout_players);
        gallery = (LinearLayout) findViewById(R.id.tennis_layout_gallery);
        recycler1 = findViewById(R.id.tennis_recycler_1);
        recycler2 = findViewById(R.id.tennis_recycler_2);

        strings1 = getResources().getStringArray(R.array.tennis_players);
        strings2 = getResources().getStringArray(R.array.tennis_description);

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
                        Intent intent = new Intent(TennisActivity.this,MenuActivity.class);
                        startActivity(intent);finish();
                    }
                }
                return true;
            }
        });


    }
}

