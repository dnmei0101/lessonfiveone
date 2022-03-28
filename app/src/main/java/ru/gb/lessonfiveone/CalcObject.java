package ru.gb.lessonfiveone;

import android.widget.EditText;
import android.widget.TextView;

public class CalcObject {
    protected String inputString;
    protected char operationChar;
    protected double firstNumber;
    protected double secondNumber;

    CalcObject() {
        inputString = "";
        operationChar = '0';
    }

    CalcObject(String input) {
        inputString = input;
    }

    double calcAction() {
        if (this.operationChar == '+') {
            return this.firstNumber + this.secondNumber;
        }
        else if (this.operationChar == '-') {
            return this.firstNumber - this.secondNumber;
        }
        else if (this.operationChar == '*') {
            return this.firstNumber * this.secondNumber;
        }
        else if (this.operationChar == '÷') {
            return this.firstNumber / this.secondNumber;
        }
        return 0;
    }

}
