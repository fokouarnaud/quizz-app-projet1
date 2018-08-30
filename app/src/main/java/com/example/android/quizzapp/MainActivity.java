package com.example.android.quizzapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    boolean hasCorrectAnswerQuestionOne = false;
    boolean hasCorrectAnswerQuestionTwo = false;
    boolean hasCheckedAnswerOneQuestionThree = false;
    boolean hasCheckedAnswerThreeQuestionThree = false;
    boolean hasCheckedAnswerOneQuestionFour = false;
    boolean hasCheckedAnswerTwoQuestionFour = false;
    boolean hasCorrectAnswerQuestionFive = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when a radio  button in question one is clicked
     */
    public void onRadioButtonQuestionOneClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        hasCorrectAnswerQuestionOne = false;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question_one_answer_three_radio_button:
                // question_one_answer_three_radio_button are the best
                hasCorrectAnswerQuestionOne = checked;

                break;

        }
    }

    /**
     * this method is called when a radio  button in question two is clicked
     */
    public void onRadioButtonQuestionTwoClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        hasCorrectAnswerQuestionTwo = false;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question_two_answer_one_radio_button:
                // question_two_answer_one_radio_button are the best
                hasCorrectAnswerQuestionTwo = checked;

                break;

        }
    }

    /**
     * this method is called when a checkbox in question three is clicked
     */
    public void onCheckboxQuestionThreeClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.question_three_answer_one_checkbox:
                // question_three_answer_one_checkbox is correct
                hasCheckedAnswerOneQuestionThree = checked;

                break;

            case R.id.question_three_answer_three_checkbox:
                // question_three_answer_three_checkbox is correct
                hasCheckedAnswerThreeQuestionThree = checked;

                break;

        }
    }

    /**
     * this method is called when a checkbox in question four is clicked
     */
    public void onCheckboxQuestionFourClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.question_four_answer_one_checkbox:
                // question_four_answer_one_checkbox is correct
                hasCheckedAnswerOneQuestionFour = checked;

                break;
            case R.id.question_four_answer_two_checkbox:
                // question_four_answer_two_checkbox is correct
                hasCheckedAnswerTwoQuestionFour = checked;

                break;
        }
    }

    /**
     * this method is called when button submit is clicked
     */
    public void onButtonSubmitClicked(View view) {

        int numberOfCorrectAnswer = 0;

        // get text question_five_answer
        EditText textName = (EditText) findViewById(R.id.question_five_answer_edit_text);
        String name = textName.getText().toString();

        // check has correct answer question five
        hasCorrectAnswerQuestionFive = name.toUpperCase().equals("SINEK");


        // calculate number of correct answer
        if (hasCorrectAnswerQuestionOne) {
            numberOfCorrectAnswer++;
        }
        if (hasCorrectAnswerQuestionTwo) {
            numberOfCorrectAnswer++;
        }
        if (hasCheckedAnswerOneQuestionThree) {
            numberOfCorrectAnswer++;
        }
        if (hasCheckedAnswerThreeQuestionThree) {
            numberOfCorrectAnswer++;
        }
        if (hasCheckedAnswerOneQuestionFour) {
            numberOfCorrectAnswer++;
        }
        if (hasCheckedAnswerTwoQuestionFour) {
            numberOfCorrectAnswer++;
        }
        if (hasCorrectAnswerQuestionFive) {
            numberOfCorrectAnswer++;
        }


        // generate toast message
        Context context = getApplicationContext();
        CharSequence textToast = numberOfCorrectAnswer + " bonne(s) réponse(s) sur 7!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, textToast, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
