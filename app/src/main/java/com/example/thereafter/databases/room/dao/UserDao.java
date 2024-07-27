package com.example.thereafter.databases.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.thereafter.databases.room.entities.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity user);

    @Update
    void update(UserEntity user);

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM user")
    List<UserEntity> getAllUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    UserEntity getUserById(int id);
}

