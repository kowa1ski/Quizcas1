package com.example.android.quizcas1;

import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    int MyScore = 0;
    String name = "";
    Boolean resultIsDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when submit button is clicked.
     */
    public void submitQuiz(View view){

        if (resultIsDone){
            Toast.makeText(this, name + " if you want play again press reset button", Toast.LENGTH_LONG).show();
            return;
        }

        getUserName();
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        displayResult(MyScore);
        Toast.makeText(this, name + ", your score is " + MyScore + " out of 5 possible.", Toast.LENGTH_LONG).show();

        resultIsDone = true;
        }



    /**
     * This method is getting users name.
     */
    private void getUserName() {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        name = nameEditable.toString();
    }

        /**
         * This method is for to now if question 1 is great.
         */
    private void questionOne() {
        RadioGroup question = (RadioGroup) findViewById(R.id.q1);
        int answer = question.getCheckedRadioButtonId();

        if (answer == R.id.q1_64) {
            MyScore += 1;
        }
    }

    /**
     * This method is for to now if question 2 is great.
     */
    private void questionTwo() {
        RadioGroup question = (RadioGroup) findViewById(R.id.q2);
        int answer = question.getCheckedRadioButtonId();

        if (answer == R.id.q2_d4) {
            MyScore += 1;
        }
    }

    // This method is for to now if question 3 is great.
    private void questionThree() {
        CheckBox chessPlayer1 = (CheckBox) findViewById(R.id.q3_Morphy);
        boolean chessPlayer1Checked = chessPlayer1.isChecked();

        CheckBox chessPlayer2 = (CheckBox) findViewById(R.id.q3_Botvinnik);
        boolean chessPlayer2Checked = chessPlayer2.isChecked();

        CheckBox chessPlayer3 = (CheckBox) findViewById(R.id.q3_Dostoyevski);
        boolean chessPlayer3Checked = chessPlayer3.isChecked();

        if (chessPlayer1Checked && chessPlayer2Checked && !chessPlayer3Checked) {
            MyScore += 1;
        }
        else{
            Toast.makeText(this, name + ", Question 4 is wrong. In these question te answer have two names ;-)", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method is for to now if question 4 is great.
     */
    private void questionFour() {
        RadioGroup question = (RadioGroup) findViewById(R.id.q4);
        int answer = question.getCheckedRadioButtonId();

        if (answer == R.id.q4_bishops) {
            MyScore += 1;
        }
    }

    /**
     * This method is for to now if question 5 is great.
     */
    private void questionFive() {
        // Get player's name
        EditText name_player = (EditText) findViewById(R.id.name_player);
        Editable nameEditable = name_player.getText();
        String nameKarpov = nameEditable.toString();
        // calculate correct answer
        if (nameKarpov.equals("Karpov")) {
            MyScore += 1;
        }
    }

    /**
     * This method displays the result on the screen.
     */
    private void displayResult(int MyScoreToDisplay) {
        TextView ScoreToDisplay = (TextView) findViewById(R.id.score_view);
        ScoreToDisplay.setText(String.valueOf(MyScoreToDisplay));
    }

    /**
     * This method reset the result on the screen.
     */
    public void resetScore(View view) {
        TextView quantityToCeroTextView = (TextView) findViewById(R.id.score_view);
        quantityToCeroTextView.setText("0");
        resultIsDone = false;
        MyScore = 0;
    }
}