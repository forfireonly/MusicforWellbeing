package com.example.annascott.musicforwellbeing;


import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.Window.FEATURE_NO_TITLE;

public class StretchingMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching_music);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> Songs = new ArrayList<Song>();

        Songs.add(new Song("Girl on Fire", "Alicia Keys"));
        Songs.add(new Song("Dirty Paws", "of Monsters and Man"));
        Songs.add(new Song("Dissolve Me", "alt-J"));
        Songs.add(new Song("All Eyes on You", "St.Lucia"));
        Songs.add(new Song("Doin' It Right", "Daft Punk"));
        Songs.add(new Song("The Wire", "Haim"));
        Songs.add(new Song("Royals", "Lorde"));
        Songs.add(new Song("Heartbeats", "The Knife"));
        Songs.add(new Song("The Light", "Common"));
        Songs.add(new Song("You Never Know", "Wilco"));


        SongAdapter adapter = new SongAdapter(this, Songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Song song = Songs.get(i);

                final Dialog dialog = new Dialog(StretchingMusicActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.stretching_song);
                String name = song.getsongTitle();
                TextView text = (TextView) dialog.findViewById(R.id.stretching_song_playing);
                text.setText(name);
                String singer = song.getsingerName();
                TextView text2 = (TextView) dialog.findViewById(R.id.stretching_singer_playing);
                text2.setText(singer);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.FILL_PARENT);
                Button PopUpClose = (Button) dialog.findViewById(R.id.dialogButtonOK);
                PopUpClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        LayoutInflater inflater = getLayoutInflater();

                        View layout = inflater.inflate(R.layout.pickanothersong,
                                (ViewGroup) findViewById(R.id.pick));
                        //Toast.makeText(getApplicationContext(), "Pick another song", Toast.LENGTH_LONG).show();
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();


                    }

                });

            }


        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}