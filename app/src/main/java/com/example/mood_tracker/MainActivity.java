package com.example.mood_tracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn_plus = findViewById(R.id.btn_plus);
        if (btn_plus != null) {
            btn_plus.setOnClickListener(v -> {

                Intent intent = new Intent(MainActivity.this, Mood_Tracker.class);
                startActivity(intent);
            });
        }
    }
}

