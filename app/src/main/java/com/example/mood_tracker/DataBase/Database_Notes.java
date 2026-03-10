package com.example.mood_tracker.DataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database_Notes  extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Notes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Notes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TITLE = "Title";
    private static final String COLUMN_TEXT = "text";


    public Database_Notes(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

     String query =
             "CREATE TABLE " + TABLE_NAME +
                     " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     COLUMN_DATE + " TEXT, " +
                     COLUMN_TITLE + " TEXT, " +
                     COLUMN_TEXT + " TEXT);";

     db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addNote(String date, String title, String text) {

       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

     cv.put(COLUMN_DATE, date);
     cv.put(COLUMN_TITLE, title);
     cv.put(COLUMN_TEXT, text);

     long result = db.insert(TABLE_NAME, null, cv);
     if (result == -1) {
         Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
     }
     else {
         Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
     }

    }
}


