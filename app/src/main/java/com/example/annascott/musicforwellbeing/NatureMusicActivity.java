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

public class NatureMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_music);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final ArrayList<Song> Songs = new ArrayList<Song>();

        Songs.add(new Song("Sleep Waves", "Ocean"));
        Songs.add(new Song("Rainforest Enchantment", "Birds of Rainforest"));
        Songs.add(new Song("Drift Away", "Rain"));
        Songs.add(new Song("Beach Sunset", "Ocean"));
        Songs.add(new Song("Cooling Breeze", "Wind"));
        Songs.add(new Song("Winding Down", "Mountain Creek"));
        Songs.add(new Song("Falling Asleep", "Waterfall"));
        Songs.add(new Song("Relaxing Mix", "Nature Sounds"));
        Songs.add(new Song("Dreamland", "Flute and Wind"));
        Songs.add(new Song("Forrest Conversation", "Wind Blowing Through The Leaves"));


        SongAdapter adapter = new SongAdapter(this, Songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Song song = Songs.get(i);

                final Dialog dialog = new Dialog(NatureMusicActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.nature_song);
                String name = song.getsongTitle();
                TextView text = (TextView) dialog.findViewById(R.id.nature_song_playing);
                text.setText(name);
                String singer = song.getsingerName();
                TextView text2 = (TextView) dialog.findViewById(R.id.nature_singer_playing);
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
