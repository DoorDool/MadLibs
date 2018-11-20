package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;

public class input extends Activity {

    public Story unfilledstory;
    private TextView wordsleft;
    private TextView kindofwords;
    private EditText wordsinput;
    private Button okbutton;
    private InputStream inputStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        //TextView text1 = findViewById(R.id.textView2);
        //text1.setText("Fill in the words to complete the story!");

        wordsleft = findViewById(R.id.textView3);
        kindofwords = findViewById(R.id.textView4);
        wordsinput = findViewById(R.id.editText);
        okbutton = findViewById(R.id.button2);
        inputStory = this.getResources().openRawResource(R.raw.madlib0_simple);
        // save inputstory in a variable
        unfilledstory = new Story(inputStory);

        kindofwords.append(" " + unfilledstory.getNextPlaceholder());
        wordsleft.setText(unfilledstory.getPlaceholderCount() + " word(s) left");
        wordsinput.setHint(unfilledstory.getNextPlaceholder());
    }

    public void okButton(View view) {

        int number;
        String word = String.valueOf(wordsinput.getText());

        unfilledstory.fillInPlaceholder(word);
        number = unfilledstory.getPlaceholderRemainingCount();

        wordsinput.setText("");

        if (number == 0) {
            Intent story_screen = new Intent (this, storyscreen.class);
            story_screen.putExtra("filledstory", unfilledstory);
            startActivity(story_screen);
        }

        kindofwords.setText("Please type a/an");
        wordsleft.setText("word(s) left");
        kindofwords.append(" " + unfilledstory.getNextPlaceholder());
        wordsleft.setText(number + " word(s) left");
        wordsinput.setHint(unfilledstory.getNextPlaceholder());
    }

}
