package com.example.annascott.musicforwellbeing;

public class Song {
    private String msongTitle;
    private String msingerName;

    public Song(String songTitle, String singerName) {
        msongTitle = songTitle;
        msingerName = singerName;
    }

    public String getsongTitle() {
        return msongTitle;
    }

    public String getsingerName() {
        return msingerName;
    }
}
