package com.example.dorin.dorinda_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends Activity {

    private TextView wordsleft;
    private TextView kindofwords;
    private EditText wordsinput;
    private Story choosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);
        // initialze textViews and editText
        wordsleft = findViewById(R.id.words_left);
        kindofwords = findViewById(R.id.kind_of_word);
        wordsinput = findViewById(R.id.words_input);
        // get choosed story
        Intent calledActivity = getIntent();
        choosed = (Story) calledActivity.getSerializableExtra("choosedstory");
        // fill kindofwords with placeholder
        kindofwords.append(" " + choosed.getNextPlaceholder());
        // fill wordsleft with count
        wordsleft.setText(choosed.getPlaceholderCount() + " word(s) left");
        // fill in wordsinput as hint placeholder
        wordsinput.setHint(choosed.getNextPlaceholder());
    }

    // save variables for rotating mobile
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("hint", wordsinput.getHint().toString());
        outState.putString("kind", kindofwords.getText().toString());
        outState.putString("left", wordsleft.getText().toString());
    }

    // get variables after rotating mobile
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        wordsinput.setHint(inState.getString("hint"));
        kindofwords.setText(inState.getString("kind"));
        wordsleft.setText(inState.getString("left"));
    }

    // method for click on OK button
    public void okButton(View view) {
        // get input from wordsinput
        String word = String.valueOf(wordsinput.getText());
        // fill in word in story
        choosed.fillInPlaceholder(word);
        // make wordsinput empty
        wordsinput.setText("");
        // if all words are fill in
        if (choosed.getPlaceholderRemainingCount() == 0) {
            // go to StoryscreenActivity with filled story
            Intent story_screen = new Intent (this, StoryscreenActivity.class);
            story_screen.putExtra("filledstory", choosed);
            startActivity(story_screen);
        }
        // reset all textViews, editTexts
        kindofwords.setText("Please type a/an");
        wordsleft.setText("word(s) left");
        kindofwords.append(" " + choosed.getNextPlaceholder());
        wordsleft.setText(choosed.getPlaceholderRemainingCount() + " word(s) left");
        wordsinput.setHint(choosed.getNextPlaceholder());
    }

    // when backPressed go to choiseActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(InputActivity.this, ChoiseActivity.class);
        startActivity(intent);
    }

}
