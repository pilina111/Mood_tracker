package com.example.mood_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;

import android.widget.CalendarView;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calendar_General extends AppCompatActivity {

    Button button2;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calendar_general);

        button2 = findViewById(R.id.button2);

        if (button2 != null) {
            button2.setOnClickListener(v -> {

                Intent intent = new Intent(Calendar_General.this, MainActivity.class);
                startActivity(intent);
            });
        }



      calendar = findViewById(R.id.calendar);
        if (calendar != null) {
            long today = Calendar.getInstance().getTimeInMillis();
            calendar.setDate(today, true, true);
        }

    }
}