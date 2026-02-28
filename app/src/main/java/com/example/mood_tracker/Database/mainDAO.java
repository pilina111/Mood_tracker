package com.example.mood_tracker.Database;

import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;import androidx.room.Query;
import com.example.mood_tracker.Models.Notes;
import java.util.List;

@Dao
public interface mainDAO {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes")
    List<Notes> getAll();


    @Query("UPDATE notes SET title = :title, notes = :notes, date = :date WHERE ID = :id")
    void update(int id, String title, String notes, String date);

    @Delete
    void delete(Notes notes);
}



