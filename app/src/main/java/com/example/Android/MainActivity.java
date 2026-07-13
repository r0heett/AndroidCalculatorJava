package com.example.Android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        result = findViewById(R.id.result);

        add.setOnClickListener(v -> calculate('+'));

        sub.setOnClickListener(v -> calculate('-'));

        mul.setOnClickListener(v -> calculate('*'));

        div.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operation) {

        if(num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty()){

            Toast.makeText(this, R.string.enter_both_numbers, Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());

        double ans;

        switch(operation){

            case '+':
                ans = n1 + n2;
                break;

            case '-':
                ans = n1 - n2;
                break;

            case '*':
                ans = n1 * n2;
                break;

            case '/':
                if(n2==0){
                    Toast.makeText(this, R.string.cannot_divide_by_zero, Toast.LENGTH_SHORT).show();
                    return;
                }
                ans = n1 / n2;
                break;
            default:
                ans = 0;
        }

        result.setText(getString(R.string.result_format, ans));

    }
}