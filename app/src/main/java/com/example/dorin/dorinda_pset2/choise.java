package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class choise extends Activity {

    private Story choosedstory;
    private InputStream inputStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choise_screen);
    }

    public void make(View view) {

        Button button = (Button) view;

        switch(button.getId()) {
            case(R.id.button9):
                inputStory = this.getResources().openRawResource(R.raw.madlib0_simple);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button5):
                inputStory = this.getResources().openRawResource(R.raw.madlib1_tarzan);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button6):
                inputStory = this.getResources().openRawResource(R.raw.madlib2_university);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button7):
                inputStory = this.getResources().openRawResource(R.raw.madlib3_clothes);
                choosedstory = new Story(inputStory);
                break;
            case(R.id.button8):
                inputStory = this.getResources().openRawResource(R.raw.madlib4_dance);
                choosedstory = new Story(inputStory);
                break;
        }

        Intent input_screen = new Intent (this, input.class);
        input_screen.putExtra("choosedstory", choosedstory);
        startActivity(input_screen);

    }
}
