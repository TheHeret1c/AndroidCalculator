package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

// Хубларян Эдуард 303 группа

public class MainActivity extends AppCompatActivity {

    EditText textA;
    EditText textB;
    TextView textResult;

    double valueOne, valueTwo, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.textBoxA);
        textB = findViewById(R.id.textBoxB);
        textResult = findViewById(R.id.textBoxResult);
    }


    public void Buttons(View v){
        switch(v.getId()){
            case R.id.buttonAdd:
                Add();
                break;
            case R.id.buttonSubtract:
                Subtract();
                break;
            case R.id.buttonDivide:
                Divide();
                break;
            case R.id.buttonMultiply:
                Multiply();
                break;
            case R.id.buttonSin:
                Sin();
                break;
            case R.id.buttonCos:
                Cos();
                break;
            case R.id.buttonTan:
                Tan();
                break;
            case R.id.buttonSqrt:
                Sqrt();
                break;
            case R.id.buttonPow:
                Pow();
                break;
            case R.id.buttonLn:
                Ln();
                break;
            case R.id.buttonLog:
                Log();
                break;
        }
    }

    public void Add(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        result = valueOne + valueTwo;

        textResult.setText(String.valueOf(result));
    }

    public void Subtract(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        result = valueOne - valueTwo;

        textResult.setText(String.valueOf(result));
    }

    public void Divide(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        if (valueTwo == 0)
        {
            Toast toast = Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        result = valueOne / valueTwo;

        textResult.setText(String.valueOf(result));
    }

    public void Multiply(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        result = valueOne * valueTwo;

        textResult.setText(String.valueOf(result));
    }

    public void Sin(){
        if (ConvertOne() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());

        result = Math.sin(valueOne);
        //textResult.setText(String.valueOf(result));
        textResult.setText(new DecimalFormat("##.##").format(result));
    }

    public void Cos(){
        if (ConvertOne() == false)
            return;
        valueOne = Double.parseDouble((textA.getText().toString()));

        result = Math.cos(valueOne);

        textResult.setText(new DecimalFormat("##.##").format(result));
    }

    public void Tan(){
        if (ConvertOne() == false)
            return;
        valueOne = Double.parseDouble((textA.getText().toString()));

        result = Math.tan(valueOne);

        textResult.setText(new DecimalFormat("##.##").format(result));
    }

    public void Sqrt(){
        if (ConvertOne() == false)
            return;
        valueOne = Double.parseDouble((textA.getText().toString()));
        if (valueOne < 0)
        {
            Toast toast = Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        result = Math.sqrt(valueOne);

        textResult.setText(new DecimalFormat("##.##").format(result));
    }

    public void Pow(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        result = Math.pow(valueOne, valueTwo);

        textResult.setText(String.valueOf(result));
    }

    public void Ln(){
        if (ConvertOne() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        if (valueOne < 0)
        {
            Toast toast = Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        result = Math.log(valueOne);

        textResult.setText(new DecimalFormat("##.##").format(result));


    }

    public void Log(){
        if (ConvertTwo() == false)
            return;
        valueOne = Double.parseDouble(textA.getText().toString());
        valueTwo = Double.parseDouble(textB.getText().toString());

        result = Math.log10(valueOne) / Math.log10(valueTwo);

        textResult.setText(new DecimalFormat("##.##").format(result));
    }

    public boolean ConvertOne(){
        try{
            valueOne = Double.parseDouble(textA.getText().toString());
        }catch (Exception ex)
        {
            Toast toast = Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        return true;
    }

    public boolean ConvertTwo(){
        try {
            valueOne = Double.parseDouble(textA.getText().toString());
            valueTwo = Double.parseDouble(textB.getText().toString());
        }catch(Exception ex)
        {
            Toast toast = Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        return true;
    }
}