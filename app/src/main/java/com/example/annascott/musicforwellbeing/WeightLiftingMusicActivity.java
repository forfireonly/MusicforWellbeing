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

public class WeightLiftingMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_lifting_music);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> Songs = new ArrayList<Song>();

        Songs.add(new Song("Remember The Name", "Fort Minor"));
        Songs.add(new Song("Black And Yellow", "Wiz Khalifa"));
        Songs.add(new Song("Low", "Nicki Minaj"));
        Songs.add(new Song("Put On", "Kanye West"));
        Songs.add(new Song("Started From the Bottom", "Drake"));
        Songs.add(new Song("Iron Man", "Black Sabbath"));
        Songs.add(new Song("Black Dog", "Led Zeppelin"));
        Songs.add(new Song("Rip This Joint", "The Rolling Stones"));
        Songs.add(new Song("The Ride of the Valkyries", "Richard Wagner"));
        Songs.add(new Song("Droppin' Plates", "Disturbed"));


        SongAdapter adapter = new SongAdapter(this, Songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Song song = Songs.get(i);

                final Dialog dialog = new Dialog(WeightLiftingMusicActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.weightlifting_song);
                String name = song.getsongTitle();
                TextView text = (TextView) dialog.findViewById(R.id.weightlifting_song_playing);
                text.setText(name);
                String singer = song.getsingerName();
                TextView text2 = (TextView) dialog.findViewById(R.id.weightlifting_singer_playing);
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
