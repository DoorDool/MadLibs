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

    private TextView wordsleft;
    private TextView kindofwords;
    private EditText wordsinput;
    //private Button okbutton;
    //private InputStream inputStory;
    private Story choosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        wordsleft = findViewById(R.id.textView3);
        kindofwords = findViewById(R.id.textView4);
        wordsinput = findViewById(R.id.editText);
        //okbutton = findViewById(R.id.button2);

        Intent calledActivity = getIntent();
        choosed = (Story) calledActivity.getSerializableExtra("choosedstory");

        kindofwords.append(" " + choosed.getNextPlaceholder());
        wordsleft.setText(choosed.getPlaceholderCount() + " word(s) left");
        wordsinput.setHint(choosed.getNextPlaceholder());
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString("hint", wordsinput.getHint().toString());
        outState.putString("kind", kindofwords.getText().toString());
        outState.putString("left", wordsleft.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        wordsinput.setHint(inState.getString("hint"));
        kindofwords.setText(inState.getString("kind"));
        wordsleft.setText(inState.getString("left"));
    }

    public void okButton(View view) {

        int number;
        String word = String.valueOf(wordsinput.getText());

        choosed.fillInPlaceholder(word);
        number = choosed.getPlaceholderRemainingCount();

        wordsinput.setText("");

        if (number == 0) {
            Intent story_screen = new Intent (this, storyscreen.class);
            story_screen.putExtra("filledstory", choosed);
            startActivity(story_screen);
        }

        kindofwords.setText("Please type a/an");
        wordsleft.setText("word(s) left");
        kindofwords.append(" " + choosed.getNextPlaceholder());
        wordsleft.setText(number + " word(s) left");
        wordsinput.setHint(choosed.getNextPlaceholder());
    }

}
