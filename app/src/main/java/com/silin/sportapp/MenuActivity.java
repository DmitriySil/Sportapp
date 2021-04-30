package com.silin.sportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    private Button football;
    private Button basketball;
    private Button boxing;
    private Button tennis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        football = (Button) findViewById(R.id.football_btn);
        football.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,FootballActivity.class);
            startActivity(intent);finish();
        });

        basketball = (Button) findViewById(R.id.basketball_btn);
        basketball.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,BasketballActivity.class);
            startActivity(intent);finish();
        });

        boxing = (Button) findViewById(R.id.boxing_btn);
        boxing.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,BoxingActivity.class);
            startActivity(intent);finish();
        });

        tennis = (Button) findViewById(R.id.tennis_btn);
        tennis.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,TennisActivity.class);
            startActivity(intent);finish();
        });
    }
}
