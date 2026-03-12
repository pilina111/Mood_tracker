package com.example.mood_tracker;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;

import com.example.mood_tracker.DataBase.Database_Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_plus;
    Button btn_calend;

    RecyclerView recycler_home;
    FloatingActionButton fab_add;

    Database_Notes myDB;
    ArrayList<String> note_id, date, title, text;
CustomAdapter customAdapter;




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

 myDB = new Database_Notes(MainActivity.this);
 note_id = new ArrayList<>();
 date = new ArrayList<>();
 title = new ArrayList<>();
 text = new ArrayList<>();


storeDataInArrays();
customAdapter = new CustomAdapter(MainActivity.this, note_id, date, title, text);
recycler_home.setAdapter(customAdapter);
recycler_home.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    void storeDataInArrays() {
Cursor cursor = myDB.readAllData();
if (cursor.getCount() == 0) {
    Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
} else {
while (cursor.moveToNext()) {
    note_id.add(cursor.getString(0));
    date.add(cursor.getString(1));
    title.add(cursor.getString(2));
    text.add(cursor.getString(3));
}
    }
}

    }



