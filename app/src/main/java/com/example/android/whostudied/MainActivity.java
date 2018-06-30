package com.example.android.whostudied;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaration of the container
    public static final String EXTRA_MESSAGE =
            //location of the container
            "com.example.android.whostudied.extra.MESSAGE";
    //initiate numberOfSubjects to evaluate
    //numberOfSubjects that would be displayed in test page
    int numberOfSubjects = 0;
    //Chant for Male or Female
    String chant = "";
    Boolean NigeriaBoxChecked = false;
    Boolean FounderBoxChecked = false;
    Boolean StartupBoxChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    //choosing girls or boys team
    public void radio_click(View view) {
        //maleRBtn is changed from View to RadioButton and stored in MaleRadio
        RadioButton MaleRadio = findViewById(R.id.maleRBtn);
        Boolean MaleButtonSelected = MaleRadio.isChecked();
        TextView boysHail = findViewById(R.id.boys_house);

        //femaLeRBtn is changed from View to RadioButton and stored in FemaleRadio
        RadioButton FemaleRadio = findViewById(R.id.femaleRBtn);
        Boolean FemaleButtonSelected = FemaleRadio.isChecked();
        TextView girlsHail = findViewById(R.id.girls_house);

        //When "Boys" is selected
        if (MaleButtonSelected) {
            boysHail.setTextSize(12);
            chant = "for the guys";
        } else boysHail.setTextSize(0);
        //When "Girls" is selected
        if (FemaleButtonSelected) {
            girlsHail.setTextSize(12);
            chant = "for the babes";
        } else girlsHail.setTextSize(0);
    }

    //When you check Nigeria
    public void onCheckboxNigeria(View view) {
        numberOfSubjects = numberOfSubjects + 1;
        if (numberOfSubjects >= 4) {//number of subjects cannot be more than 3
            return;
        }
        CheckBox nigeriaBox = findViewById(R.id.nigeria);
        NigeriaBoxChecked = nigeriaBox.isChecked();
        if (NigeriaBoxChecked) {
            nigeriaBox.setChecked(true);
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "You will answer " + numberOfSubjects * 2 + " questions", duration);
            toast.show();
        }
    }

    //When you check Founders
    public void onCheckboxFounders(View view) {
        numberOfSubjects = numberOfSubjects + 1;
        if (numberOfSubjects >= 4) {//number of subjects cannot be more than 3
            return;
        }
        CheckBox founderBox = findViewById(R.id.founders);
        FounderBoxChecked = founderBox.isChecked();
        if (FounderBoxChecked) {
            founderBox.setChecked(true);
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "You will answer " + numberOfSubjects * 2 + " questions", duration);
            toast.show();
        }
    }

    //When you check Startups
    public void onCheckboxStartups(View view) {
        numberOfSubjects = numberOfSubjects + 1;
        if (numberOfSubjects >= 4) {//number of subjects cannot be more than 3
            return;
        }
        CheckBox startupBox = findViewById(R.id.startups);
        StartupBoxChecked = startupBox.isChecked();
        if (StartupBoxChecked) {
            startupBox.setChecked(true);
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "You will answer " + numberOfSubjects * 2 + " questions", duration);
            toast.show();
        }
    }

    //when begin button is clicked
    public void startTest(View view) {
        //logic for checking which questions to display on Test Activity
        if (NigeriaBoxChecked) {
            NigeriaBoxChecked = true;
        }
        if (FounderBoxChecked) {
            FounderBoxChecked = true;
        }
        if (StartupBoxChecked) {
            StartupBoxChecked = true;
        }

        // Get student's name
        //Change from View to EditText
        EditText nameField = findViewById(R.id.name_input);
        //save the Editable text in nameEditable variable
        Editable nameEditable = nameField.getText();
        //Convert to String type and store in name variable
        String name = nameEditable.toString();
        //Declare and Initiate a new Intent object
        Intent intent = new Intent(this, TestPage.class);
        //Adding data to the Intent, to be transferred to Test Activity
        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra(Intent.EXTRA_TEXT, chant);
        intent.putExtra(Intent.EXTRA_RESULT_RECEIVER, NigeriaBoxChecked);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, FounderBoxChecked);
        intent.putExtra(Intent.EXTRA_PROCESS_TEXT, StartupBoxChecked);
        //launch Test Activity
        startActivity(intent);
    }
}
