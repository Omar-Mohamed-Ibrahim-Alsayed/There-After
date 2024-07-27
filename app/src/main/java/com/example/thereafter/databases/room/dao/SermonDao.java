package com.example.thereafter.databases.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.thereafter.databases.room.entities.SermonEntity;

import java.util.List;

@Dao
public interface SermonDao {

    @Insert
    void insert(SermonEntity sermon);

    @Update
    void update(SermonEntity sermon);

    @Delete
    void delete(SermonEntity sermon);

    @Query("SELECT * FROM sermons")
    List<SermonEntity> getAllSermons();

    @Query("SELECT * FROM sermons WHERE id = :id")
    SermonEntity getSermonById(Integer id);
}
