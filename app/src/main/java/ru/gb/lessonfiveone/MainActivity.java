package ru.gb.lessonfiveone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonDelete;
    private Button buttonPoint;

    private Button buttonResult;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMulti;
    private Button buttonDivision;
    private ImageView buttonSettings;

    private EditText inputForm;
    private TextView resultText;

    private String result;

    private char operationChar = '0';
    final String INPUT = "INPUT";
    final String RESULT = "RESULT";

    CalcObject initial = new CalcObject();
    CalcObject currentCalc = initial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            currentCalc.inputString = savedInstanceState.getString(INPUT);
        }

        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        buttonZero = findViewById(R.id.button_zero);
        buttonPoint = findViewById(R.id.button_point);

        inputForm = findViewById(R.id.calc_input_form);
        resultText = findViewById(R.id.result_numbers_text);

        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMulti = findViewById(R.id.button_multi);
        buttonDivision = findViewById(R.id.button_division);
        buttonDelete = findViewById(R.id.button_delete);
        buttonResult = findViewById(R.id.button_result);
        buttonSettings = findViewById(R.id.settings_button);

        resultText.setText(currentCalc.inputString);

        buttonOne.setOnClickListener(v -> {
            currentCalc.inputString += "1";
            inputForm.setText(currentCalc.inputString);
        });
        buttonTwo.setOnClickListener(v -> {
            currentCalc.inputString += "2";
            inputForm.setText(currentCalc.inputString);
        });
        buttonThree.setOnClickListener(v -> {
            currentCalc.inputString += "3";
            inputForm.setText(currentCalc.inputString);
        });
        buttonFour.setOnClickListener(v -> {
            currentCalc.inputString += "4";
            inputForm.setText(currentCalc.inputString);
        });
        buttonFive.setOnClickListener(v -> {
            currentCalc.inputString += "5";
            inputForm.setText(currentCalc.inputString);
        });
        buttonSix.setOnClickListener(v -> {
            currentCalc.inputString += "6";
            inputForm.setText(currentCalc.inputString);
        });
        buttonSeven.setOnClickListener(v -> {
            currentCalc.inputString += "7";
            inputForm.setText(currentCalc.inputString);
        });
        buttonEight.setOnClickListener(v -> {
            currentCalc.inputString += "8";
            inputForm.setText(currentCalc.inputString);
        });
        buttonNine.setOnClickListener(v -> {
            currentCalc.inputString += "9";
            inputForm.setText(currentCalc.inputString);
        });

        buttonZero.setOnClickListener(v -> {
            currentCalc.inputString += "0";
            inputForm.setText(currentCalc.inputString);
        });

        buttonPoint.setOnClickListener(v -> {
            currentCalc.inputString += ".";
            inputForm.setText(currentCalc.inputString);
        });

        buttonDelete.setOnClickListener(v -> {
            currentCalc.inputString = "";
            inputForm.setText(currentCalc.inputString);
        });

        buttonPlus.setOnClickListener(v -> {
            if (currentCalc.operationChar == '0') {
                currentCalc.firstNumber = Double.parseDouble(currentCalc.inputString);
                currentCalc.inputString += " + ";
            }
            else if (operationChar == '+') {}
            else {
                currentCalc.inputString = currentCalc.inputString.replace(currentCalc.operationChar, '+');
            }
            currentCalc.operationChar = '+';
            inputForm.setText(currentCalc.inputString);

        });

       buttonMinus.setOnClickListener(v -> {
            if (operationChar == '0' && !currentCalc.inputString.equals("")) {
                currentCalc.firstNumber = Double.parseDouble(currentCalc.inputString);
                currentCalc.inputString += " - ";
            }
            else if (operationChar == '-') {}
            else {
                currentCalc.inputString = currentCalc.inputString.replace(currentCalc.operationChar, '-');
            }
           currentCalc.operationChar = '-';
            inputForm.setText(currentCalc.inputString);

        });

        buttonMulti.setOnClickListener(v -> {
            if (currentCalc.operationChar == '0') {
                currentCalc.firstNumber = Double.parseDouble(currentCalc.inputString);
                currentCalc.inputString += " * ";
            }
            else if (currentCalc.operationChar == '*') {}
            else {
                currentCalc.inputString = currentCalc.inputString.replace(operationChar, '*');
            }
            currentCalc.operationChar = '*';
            inputForm.setText(currentCalc.inputString);

        });

        buttonDivision.setOnClickListener(v -> {
            if (operationChar == '0') {
                currentCalc.firstNumber = Double.parseDouble(currentCalc.inputString);
                currentCalc.inputString += " ÷ ";
            }
            else if (operationChar == '÷') {}
            else {
                currentCalc.inputString = currentCalc.inputString.replace(currentCalc.operationChar, '÷');
            }
            currentCalc.operationChar = '÷';
            inputForm.setText(currentCalc.inputString);

        });

        buttonResult.setOnClickListener(v -> {
            String substring = currentCalc.inputString.substring(currentCalc.inputString.indexOf(currentCalc.operationChar) + 2);
            currentCalc.secondNumber = Double.parseDouble(substring);
            result = Double.toString(currentCalc.calcAction());
            currentCalc.operationChar = '0';
            display(result);
            currentCalc.inputString = result;
            inputForm.setText(currentCalc.inputString);
        });

        buttonSettings.setOnClickListener(v -> {
            Intent intentSettings = new Intent(this, ActivitySettings.class);
            startActivity(intentSettings);
        });



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INPUT, currentCalc.inputString);
        if (result != null) {
            outState.putString(RESULT, result);
        }
    }

    void display (String result) {
        double resultNum = Double.parseDouble(result);
        if (resultNum % 1 > 0) {
            resultText.setText(result);
        }
        else {
            resultText.setText(Integer.toString((int)(resultNum)));
        }
    }

}