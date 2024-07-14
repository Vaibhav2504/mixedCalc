package com.example.calc;

import static java.util.Collections.sort;

import android.annotation.SuppressLint;
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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class sorting extends AppCompatActivity {
    Button back, submit;
    EditText getname1, getname2, getname3, getname4, getname6,getname5, getname7,getname8;
    TextView out;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sorting);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);
        getname1 = findViewById(R.id.name1);
        getname2 = findViewById(R.id.name2);
        getname3 = findViewById(R.id.name3);
        getname4 = findViewById(R.id.name4);
        getname5 = findViewById(R.id.name5);
        getname6 = findViewById(R.id.name6);
        getname7 = findViewById(R.id.name7);
        getname8 = findViewById(R.id.name8);
        out = findViewById(R.id.result);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent1 = new Intent(sorting.this, MainActivity2.class);
               startActivity(intent1);
           }
       });
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name1 = getname1.getText().toString();
               String name2 = getname2.getText().toString();
               String name3 = getname3.getText().toString();
               String name4 = getname4.getText().toString();
               String name5 = getname5.getText().toString();
               String name6 = getname6.getText().toString();
               String name7 = getname7.getText().toString();
               String name8 = getname8.getText().toString();
               String[] names = {name1, name2, name3, name4, name5, name6, name7, name8};
               Arrays.sort(names);
               out.setText("Sorted name list:\n");
               String sortedNames = "";
               for (String name : names) {
                   sortedNames += name + " ";
               }

               out.setText(sortedNames);
           }
       });
    }
}