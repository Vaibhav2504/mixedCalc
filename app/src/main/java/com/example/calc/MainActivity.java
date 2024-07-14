package com.example.calc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView googleicon, facebookicon, giticon, appleicon;
    Button loginbtn;
    EditText user, pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        loginbtn = findViewById(R.id.login);
        googleicon = findViewById(R.id.google);
        facebookicon = findViewById(R.id.facebook);
        giticon = findViewById(R.id.git);
        appleicon = findViewById(R.id.apple);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               intent.putExtra("USERNAME", username);
               intent.putExtra("PASSWORD", password);
               startActivity(intent);
            }
        });
        googleicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View g) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com"));
                    startActivity(intent2);
            }
        });
        facebookicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View f) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(intent3);
            }
        });
        giticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View gi) {
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
                startActivity(intent4);
            }
        });
        appleicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ap) {
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.icloud.com"));
                startActivity(intent5);
            }
        });
    }
}