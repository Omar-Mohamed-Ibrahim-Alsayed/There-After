package com.example.thereafter.databases.room.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "activities")
public class ActivityItemEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "tags")
    private String tags;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "owner")
    private String owner;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "followers")
    private Number followers;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "certification")
    private String certification;

    // Constructors, getters, and setters

    public ActivityItemEntity(String name, String tags, String description, String owner, String image, Number followers, String date, String certification) {
        this.name = name;
        this.tags = tags;
        this.description = description;
        this.owner = owner;
        this.image = image;
        this.followers = followers;
        this.date = date;
        this.certification = certification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Number getFollowers() {
        return followers;
    }

    public void setFollowers(Number followers) {
        this.followers = followers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
