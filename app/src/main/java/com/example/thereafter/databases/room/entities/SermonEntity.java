package com.example.thereafter.databases.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sermons")
public class SermonEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "owner")
    private String owner;

    @ColumnInfo(name = "badges")
    private String badges;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "rate")
    private Double rate;

    // Constructors, getters, and setters

    public SermonEntity(String name, String category, String content, String owner, String badges, String image, Double rate) {
        this.name = name;
        this.category = category;
        this.content = content;
        this.owner = owner;
        this.badges = badges;
        this.image = image;
        this.rate = rate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
