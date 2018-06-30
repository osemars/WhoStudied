package com.example.android.whostudied;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.whostudied.MainActivity.EXTRA_MESSAGE;

public class TestPage extends AppCompatActivity {
    //chant: check MainActivity, Line48 & 53
    String chant = "";
    Boolean NigeriaBoxChecked;
    Boolean FounderBoxChecked;
    Boolean StartupBoxChecked;
    int a = 0;
    int b = 0;
    int c = 0; //a,b,c are the number of questions to be displayed.
    int OVERALL_SCORE;
    Boolean moha_checked = false;
    Boolean bubu_checked = false;
    Boolean koko_checked = false;
    Boolean musa_checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);
        //Receiving data from MainActivity to TestPage.java
        //Receive name and sex of user, and store in value and chant
        Intent intent = getIntent();
        String value = getIntent().getStringExtra(EXTRA_MESSAGE);
        //Change the View where "name" should be displayed into a TextView and store in textView
        String value2 = getIntent().getStringExtra(intent.EXTRA_TEXT);
        Boolean value3 = getIntent().getBooleanExtra(intent.EXTRA_RESULT_RECEIVER, false);
        Boolean value4 = getIntent().getBooleanExtra(intent.EXTRA_ALLOW_MULTIPLE, false);
        Boolean value5 = getIntent().getBooleanExtra(intent.EXTRA_PROCESS_TEXT, false);
        TextView textView = findViewById(R.id.name_output);
        //add name to show in textView
        textView.setText(value + ", let's see how much you really know!");
        textView.setTextColor(Color.RED);
        // assign value2 to chant
        chant = value2;
        NigeriaBoxChecked = value3;
        FounderBoxChecked = value4;
        StartupBoxChecked = value5;
        //setting visibility according to the subject(s) you choose in MainActivity
        //setting visibility for questions about Nigeria
        if (value3 == true) {
            findViewById(R.id.Question_one).setVisibility(View.VISIBLE);
            findViewById(R.id.cb_musa).setVisibility(View.VISIBLE);
            findViewById(R.id.cb_mohammed).setVisibility(View.VISIBLE);
            findViewById(R.id.cb_buhari).setVisibility(View.VISIBLE);
            findViewById(R.id.cb_aliko).setVisibility(View.VISIBLE);
            findViewById(R.id.Question_two).setVisibility(View.VISIBLE);
            findViewById(R.id.FreeText).setVisibility(View.VISIBLE);
            a = 2;
        } else a = 0;
        //setting visibility for questions about Founders(Subject)
        if (value4 == true) {
            findViewById(R.id.Question_three).setVisibility(View.VISIBLE);
            findViewById(R.id.options3).setVisibility(View.VISIBLE);
            findViewById(R.id.Question_four).setVisibility(View.VISIBLE);
            findViewById(R.id.option4).setVisibility(View.VISIBLE);
            b = 2;
        } else b = 0;
        //setting visibility for questions about Startups(Subject)
        if (value5 == true) {
            findViewById(R.id.Question_5).setVisibility(View.VISIBLE);
            findViewById(R.id.options5).setVisibility(View.VISIBLE);
            findViewById(R.id.Question_6).setVisibility(View.VISIBLE);
            findViewById(R.id.option6).setVisibility(View.VISIBLE);
            c = 2;
        } else c = 0;
    }

    //onCheck methods for the Checkboxes for number1 question in Nigeria(Subject)
    public void onCheckboxmohammed(View view) {
        CheckBox mohamoha = findViewById(R.id.cb_mohammed);
        moha_checked = mohamoha.isChecked();
    }

    public void onCheckboxBuhari(View view) {
        CheckBox bubu = findViewById(R.id.cb_buhari);
        bubu_checked = bubu.isChecked();
    }

    public void alikoClick(View view) {
        CheckBox alikoko = findViewById(R.id.cb_aliko);
        koko_checked = alikoko.isChecked();
    }

    public void musaClick(View view) {
        CheckBox musa = findViewById(R.id.cb_musa);
        musa_checked = musa.isChecked();
    }

    //onClick for the submit button to submit test paper
    public void finish(View view) {
        //Evaluation the highest possible score according to the number of Subject picked
        OVERALL_SCORE = a + b + c;
        //Initializing congratulatory message to be displayed when scoring
        String passed = "Congrats";
        //initiating scores for each question
        double score1a = 0;
        double score1b = 0;
        double score1c = 0;
        double score1d = 0;
        int score2 = 0;
        int score3 = 0;
        int score4 = 0;
        int score5 = 0;
        int score6 = 0;

        //4 Checkboxes for question 1 in Nigeria(Subject)
        if (moha_checked) {
            score1a = 0.5;
        } else score1a = 0;
        if (bubu_checked) {
            score1b = 0.5;
        } else score1b = 0;
        if (koko_checked) {
            score1c = -0.5;
        } else score1c = 0;
        if (musa_checked) {
            score1d = -0.5;
        } else score1d = 0;

        //EditText for question 2 in Nigeria(Subject)
        //Answer is received, changed to String and stored in AnswerFree
        EditText FreeAnswer = findViewById(R.id.FreeText);
        String AnswerFree = FreeAnswer.getText().toString();
        String ANSWER = "Abuja";
        if (AnswerFree.equals(ANSWER)) {
            score2 = 1;
        } else score2 = 0;

        //RadioButtons for question 1 in Founders(Subject)
        RadioButton AnswerRadio3 = findViewById(R.id.option_3b);
        Boolean Radio3Selected = AnswerRadio3.isChecked();
        if (Radio3Selected) {
            score3 = 1;
        } else score3 = 0;
        //RadioButtons for question 2 in Founders(Subject)
        RadioButton AnswerRadio4 = findViewById(R.id.option_4a);
        Boolean Radio4Selected = AnswerRadio4.isChecked();
        if (Radio4Selected) {
            score4 = 1;
        } else score4 = 0;
        //RadioButtons for question 1 in Startups(Subject)
        RadioButton AnswerRadio5 = findViewById(R.id.option_5c);
        Boolean Radio5Selected = AnswerRadio5.isChecked();
        if (Radio5Selected) {
            score5 = 1;
        } else score5 = 0;
        //RadioButtons for question 2 in Startups(Subject)
        RadioButton AnswerRadio6 = findViewById(R.id.option_6a);
        Boolean Radio6Selected = AnswerRadio6.isChecked();
        if (Radio6Selected) {
            score6 = 1;
        } else score6 = 0;

        //adding up the scores and converting to percentage
        double score = score1a + score1b + score1c + score1d + score2 + score3 + score4 + score5 + score6;
        double evaluate_score = score * 100;
        double percent_score = evaluate_score / OVERALL_SCORE;
        //if no Subject is picked, so as to display 0% as the percentage_score not NaN%.
        if (OVERALL_SCORE == 0) {
            percent_score = 0;
        }
        //Say sorry if score is less than 45% and congrats (Line109) if its more
        if (percent_score < 45) {
            passed = "Sorry";
        }

        //making a toast to display the final result
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, passed + "," + " you scored " + percent_score + "% " + chant, duration);
        toast.show();
    }
}
