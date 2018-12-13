package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.InputStream;

public class ChoiseActivity extends Activity {

    private Story choosedstory;
    private InputStream inputStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choise_screen);
    }

    // method for click on button
    public void make(View view) {
        // save clicked button
        Button button = (Button) view;
        // if clicked on buttons for make a story
        switch(button.getId()) {
            case(R.id.button_simple):
                // get story from which button choose
                inputStory = this.getResources().openRawResource(R.raw.madlib0_simple);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button_tarzan):
                inputStory = this.getResources().openRawResource(R.raw.madlib1_tarzan);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button_university):
                inputStory = this.getResources().openRawResource(R.raw.madlib2_university);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button_clothes):
                inputStory = this.getResources().openRawResource(R.raw.madlib3_clothes);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button_dance):
                inputStory = this.getResources().openRawResource(R.raw.madlib4_dance);
                choosedstory = new Story(inputStory);
                break;
        }
        // go to InputActivity with choosed story
        Intent input_screen = new Intent (this, InputActivity.class);
        input_screen.putExtra("choosedstory", choosedstory);
        startActivity(input_screen);
    }

    // when backPressed go to MainActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChoiseActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
