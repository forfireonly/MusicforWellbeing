package com.example.annascott.musicforwellbeing;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class AdapterTest {

    @Rule public ActivityTestRule<RunningMusicActivity> mActivityTestRule = new ActivityTestRule<>(RunningMusicActivity.class);

    @Test public void clickOpensSong(){

        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(1).perform(click());

        onView(withId(R.id.runnung_song_playing)).check(matches(withText("Thunderstruck")));

    }
}
