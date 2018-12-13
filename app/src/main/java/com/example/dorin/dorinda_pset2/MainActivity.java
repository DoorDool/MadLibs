package com.example.dorin.dorinda_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.textView);
        // information about the game
        text.setText("Welcome to Mad Libs! I will ask you to fill in words to complete a story. You won't be able to see the whole story until you are done filling in all the missing words. That's part of the fun. Click below to get started...");
    }

    // when play button is clicked
    public void play(View view) {
        // go to ChoiseActivity
        Intent secondScreen = new Intent(this, ChoiseActivity.class);
        startActivity(secondScreen);
    }

    // when backPressed exit the game
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}
