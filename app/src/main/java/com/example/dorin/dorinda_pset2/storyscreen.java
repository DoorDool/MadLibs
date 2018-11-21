package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class storyscreen extends Activity {

    private TextView storyview;
    private Story completedstory;
    private String showstory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_screen);

        storyview = findViewById(R.id.textView6);
        Intent calledActivity = getIntent();
        completedstory = (Story) calledActivity.getSerializableExtra("filledstory");
        storyview.setText(completedstory.toString());
    }

    public void choose (View view) {

        Intent choise_screen = new Intent (this, choise.class);
        startActivity(choise_screen);
    }

}
