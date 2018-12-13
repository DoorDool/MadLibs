package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryscreenActivity extends Activity {

    private TextView storyview;
    private Story completedstory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_screen);
        // initialize textView for story
        storyview = findViewById(R.id.storyText);
        Intent calledActivity = getIntent();
        // get filled story from other activity
        completedstory = (Story) calledActivity.getSerializableExtra("filledstory");
        // fill story in storyView
        storyview.setText(completedstory.toString());
    }

    // method for clicked on 'make another story' button
    public void newStory (View view) {
        // go to ChoiseActivity
        Intent choise_screen = new Intent (this, ChoiseActivity.class);
        startActivity(choise_screen);
    }

    // when backPressed go to choiseActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StoryscreenActivity.this, ChoiseActivity.class);
        startActivity(intent);
    }

}
