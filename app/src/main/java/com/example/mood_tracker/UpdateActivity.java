package com.example.mood_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mood_tracker.DataBase.Database_Notes;

public class UpdateActivity extends AppCompatActivity {

    TextView date_output2;
    EditText title_input2;
    EditText text_input2;
    Button update;

String id, date, title, text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update2);


        date_output2 = findViewById(R.id.date_output2);
        title_input2 = findViewById(R.id.title_input2);
        text_input2 = findViewById(R.id.text_input2);
        update = findViewById(R.id.update);

        getAndSetIntentData();



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Database_Notes myDB = new Database_Notes(UpdateActivity.this);
                myDB.updateData(id, date, title, text);
            }
            });


    }

void getAndSetIntentData()
{
    if(getIntent().hasExtra("id") && getIntent().hasExtra("date") &&

    getIntent().hasExtra("title") && getIntent().hasExtra("text")){

        //Getting Data from Intent
id = getIntent().getStringExtra("id");
date = getIntent().getStringExtra("date");
title = getIntent().getStringExtra("title");
text = getIntent().getStringExtra("text");
 //Setting Intent Data
date_output2.setText(date);
title_input2.setText(title);
text_input2.setText(text);



    }

    else {

        Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();


    }
}


}