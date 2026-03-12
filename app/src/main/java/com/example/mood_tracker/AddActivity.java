package com.example.mood_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mood_tracker.DataBase.Database_Notes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {
TextView date_output;
EditText title_input;
EditText text_input;
Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        text_input = findViewById(R.id.text_input);
        add = findViewById(R.id.add);


        date_output = findViewById(R.id.date_output);

        {
            String timeStamp = new SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(Calendar.getInstance().getTime());

            date_output.setText(timeStamp);
        }

        add.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
              Database_Notes myDB = new Database_Notes(AddActivity.this);
              myDB.addNote(
                      date_output.getText().toString().trim(),
                      title_input.getText().toString().trim(),
                      text_input.getText().toString().trim()
              );
          }
          });

      }
}