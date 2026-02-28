package com.example.mood_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Calendar;
import java.util.Locale;


public class Mood_Tracker extends AppCompatActivity {
private Button button, next;
private TextView date;
private ImageButton joy, good, ok, bad, depressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mood_tracker);

        joy = findViewById(R.id.joy);
        good = findViewById(R.id.good);
        ok = findViewById(R.id.ok);
        bad = findViewById(R.id.bad);
        depressed = findViewById(R.id.depressed);
        button = findViewById(R.id.button);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Intent intent = new Intent(Mood_Tracker.this, Mood_History.class);
//startActivity(intent);
            }
        });



        if (button != null) {
            button.setOnClickListener(v -> {

                Intent intent = new Intent(Mood_Tracker.this, MainActivity.class);
                startActivity(intent);
            });
        }


        date = findViewById(R.id.date);
        if (date != null) {


            String timeStamp = new SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(Calendar.getInstance().getTime());

            date.setText(timeStamp);
        }




    }
}