package com.example.thereafter.databases.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.thereafter.databases.room.entities.PostItemEntity;

import java.util.List;

@Dao
public interface PostItemDao {

    @Insert
    void insert(PostItemEntity postItem);

    @Update
    void update(PostItemEntity postItem);

    @Delete
    void delete(PostItemEntity postItem);

    @Query("SELECT * FROM posts")
    List<PostItemEntity> getAllPosts();

    @Query("SELECT * FROM posts WHERE id = :id")
    PostItemEntity getPostById(Integer id);
}
