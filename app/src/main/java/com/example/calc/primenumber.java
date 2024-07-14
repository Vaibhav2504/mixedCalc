package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class primenumber extends AppCompatActivity {
    Button bac, sub;
    TextView out;
    EditText in;
    String primenum = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_primenumber);
        bac = findViewById(R.id.back);
        out = findViewById(R.id.output);
        sub = findViewById(R.id.submit);
        in = findViewById(R.id.input);
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(primenumber.this, MainActivity2.class);
                startActivity(intent1);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primenum = "";
                String number = in.getText().toString();
                int num = Integer.parseInt(number);
                prime(num);
                out.setText("The list of prime number = \n");
                out.append(primenum);
            }
        });
    }
    void prime(int n){
        for(int i = 2; i < n; i++){
            int a = 0;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    a = 1;
                    break;
                }
            }
            if(a != 1){
                primenum += i + " ";
            }
        }
    }
}