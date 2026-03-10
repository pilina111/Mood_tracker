package com.example.mood_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_plus;
    Button btn_calend;

    RecyclerView recycler_home;
    FloatingActionButton fab_add;


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


        btn_calend = findViewById(R.id.btn_calend);

        if (btn_calend != null) {
            btn_calend.setOnClickListener(v -> {

                Intent intent = new Intent(MainActivity.this, Calendar_General.class);
                startActivity(intent);
            });
        }


        recycler_home = findViewById(R.id.recycler_home);
        fab_add = findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AddActivity.class);
                    startActivity(intent);
            }
        });




    }
}

