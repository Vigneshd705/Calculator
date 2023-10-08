//package com.example.calculator;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.TextView;
//
//import com.google.android.material.button.MaterialButton;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView resultTv,solutionTv;
//    MaterialButton button_c,button_open_bracket,button_close_bracket;
//    MaterialButton button_divide,button_multiply,button_plus,button_minus,button_equals;
//    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
//    MaterialButton buttonAC,button_dot;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        resultTv =  findViewById(R.id.result_tv);
//        solutionTv = findViewById(R.id.solution_tv);
//
//        assignId(button_c,R.id.button_c);
//        assignId(buttonAC,R.id.button_AC);
//        assignId(button_dot,R.id.button_dot);
//        assignId(button_open_bracket,R.id.button_open_bracket);
//        assignId(button_close_bracket,R.id.button_close_bracket);
//        assignId(button_equals,R.id.button_equals);
//        assignId(button_divide,R.id.button_divide);
//        assignId(button_minus,R.id.button_minus);
//        assignId(button_multiply,R.id.button_multiply);
//        assignId(button_plus,R.id.button_plus);
//        assignId(button9,R.id.button_9);
//        assignId(button8,R.id.button_8);
//        assignId(button7,R.id.button_7);
//        assignId(button6,R.id.button_6);
//        assignId(button5,R.id.button_5);
//        assignId(button4,R.id.button_4);
//        assignId(button3,R.id.button_3);
//        assignId(button2,R.id.button_2);
//        assignId(button1,R.id.button_1);
//
//    }
//    void assignId(MaterialButton btn,int id){
//        btn=findViewById(id);
//        btn.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view){
//        MaterialButton button = (MaterialButton) view;
//        String buttonText = button.getText().toString();
//        String dataToCalculate =solutionTv.setText(buttonText);
//    }
//
//}

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import org.mozilla.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    MaterialButton button_c, button_open_bracket, button_close_bracket;
    MaterialButton button_divide, button_multiply, button_plus, button_minus, button_equals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, button_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        // Initialize the buttons
        button_c = findViewById(R.id.button_c);
        buttonAC = findViewById(R.id.button_AC);
        button_dot = findViewById(R.id.button_dot);
        button_open_bracket = findViewById(R.id.button_open_bracket);
        button_close_bracket = findViewById(R.id.button_close_bracket);
        button_equals = findViewById(R.id.button_equals);
        button_divide = findViewById(R.id.button_divide);
        button_minus = findViewById(R.id.button_minus);
        button_multiply = findViewById(R.id.button_multiply);
        button_plus = findViewById(R.id.button_plus);
        button9 = findViewById(R.id.button_9);
        button8 = findViewById(R.id.button_8);
        button7 = findViewById(R.id.button_7);
        button6 = findViewById(R.id.button_6);
        button5 = findViewById(R.id.button_5);
        button4 = findViewById(R.id.button_4);
        button3 = findViewById(R.id.button_3);
        button2 = findViewById(R.id.button_2);
        button1 = findViewById(R.id.button_1);

        // Set click listeners for the buttons
        button_c.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_open_bracket.setOnClickListener(this);
        button_close_bracket.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button9.setOnClickListener(this);
        button8.setOnClickListener(this);
        button7.setOnClickListener(this);
        button6.setOnClickListener(this);
        button5.setOnClickListener(this);
        button4.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("AC")) {
            // Clear the input
            solutionTv.setText("");
            resultTv.setText("0");
        } else if (buttonText.equals("=")) {
            // Evaluate the expression
            String expression = solutionTv.getText().toString();
            String finalResult = getResult(expression);
            resultTv.setText(finalResult);
        } else if (buttonText.equals("c")) {
            // Remove the last character
            String currentText = solutionTv.getText().toString();
            if (!currentText.isEmpty()) {
                currentText = currentText.substring(0, currentText.length() - 1);
                solutionTv.setText(currentText);
            }
        } else {
            // Append the button text to the input
            String currentText = solutionTv.getText().toString();
            currentText += buttonText;
            solutionTv.setText(currentText);
        }
    }

//public void onClick(View view) {
//        MaterialButton button = (MaterialButton) view;
//        String buttonText = button.getText().toString();
//        solutionTv.setText(buttonText);
//        String dataToCalculate =solutionTv.getText().toString();
//
//        if(buttonText.equals("AC"))
//        {
//            solutionTv.setText("");
//            resultTv.setText("0");
//            return ;
//        }
//        if(buttonText.equals("="))
//        {
//            solutionTv.setText(resultTv.getText());
//        }
//        if(buttonText.equals("c"))
//        {
//            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
//        }
//        else {
//            dataToCalculate=dataToCalculate+buttonText;
//        }
//
//        dataToCalculate = dataToCalculate+buttonText;
//        solutionTv.setText(dataToCalculate);
//
//        String finalResult = getResult(dataToCalculate);
//
//        if (!finalResult.equals("Err"))
//        {
//            resultTv.setText(finalResult);
//        }
//    }
    public String getResult(String data)
    {
        try {
            Context context =Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable  scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"javascript",1,null).toString();
            return finalResult;
        }
        catch (Exception e)
        {
            return "Err";
        }
    }
}
