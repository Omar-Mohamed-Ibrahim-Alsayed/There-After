package com.example.thereafter.databases.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.thereafter.databases.room.entities.ActivityItemEntity;

import java.util.List;

@Dao
public interface ActivityItemDao {

    @Insert
    void insert(ActivityItemEntity activityItem);

    @Update
    void update(ActivityItemEntity activityItem);

    @Delete
    void delete(ActivityItemEntity activityItem);

    @Query("SELECT * FROM activities")
    List<ActivityItemEntity> getAllActivities();

    @Query("SELECT * FROM activities WHERE id = :id")
    ActivityItemEntity getActivityById(Integer id);
}
