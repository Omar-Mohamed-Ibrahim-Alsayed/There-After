package com.example.thereafter.databases.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "badges")
    private String badges;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "rate")
    private double rate;

    @ColumnInfo(name = "sermons")
    private int sermons;

    @ColumnInfo(name = "posts")
    private int posts;

    // Constructors, getters, and setters

    public UserEntity(String name, String badges, String image, double rate, int sermons, int posts) {
        this.name = name;
        this.badges = badges;
        this.image = image;
        this.rate = rate;
        this.sermons = sermons;
        this.posts = posts;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadges() {
        return badges;
    }

    public void setBadges(String badges) {
        this.badges = badges;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getSermons() {
        return sermons;
    }

    public void setSermons(int sermons) {
        this.sermons = sermons;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }
}
