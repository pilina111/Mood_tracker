package com.example.mood_tracker;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {
TextView date_output;
EditText title_input;
EditText text_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        date_output = findViewById(R.id.date_output);

        {
            String timeStamp = new SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(Calendar.getInstance().getTime());

            date_output.setText(timeStamp);
        }
    }
}