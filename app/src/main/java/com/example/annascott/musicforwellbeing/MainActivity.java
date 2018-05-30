package com.example.annascott.musicforwellbeing;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ButtonRunning, ButtonWeightlifting, ButtonStretching, ButtonNature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonRunning = (TextView) findViewById(R.id.music_for_running);
        ButtonWeightlifting = (TextView) findViewById(R.id.music_for_lifting);
        ButtonStretching = (TextView) findViewById(R.id.music_for_stretching);
        ButtonNature = (TextView) findViewById(R.id.music_for_relaxation);

        ButtonRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        RunningMusicActivity.class);
                startActivity(myIntent);

            }
        });

        ButtonWeightlifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        WeightLiftingMusicActivity.class);
                startActivity(myIntent);
            }
        });

        ButtonStretching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        StretchingMusicActivity.class);
                startActivity(myIntent);
            }
        });

        ButtonNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        NatureMusicActivity.class);
                startActivity(myIntent);
            }
        });
    }
}