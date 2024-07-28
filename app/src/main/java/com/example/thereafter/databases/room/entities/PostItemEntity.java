package com.example.thereafter.databases.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class PostItemEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "tags")
    private String tags;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "owner")
    private String owner;

    @ColumnInfo(name = "badges")
    private String badges;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "likes")
    private Integer likes;

    @ColumnInfo(name = "comments")
    private Integer comments;

    // Constructors, getters, and setters

    public PostItemEntity(String tags, String content, String owner, String badges, String image, Integer likes, Integer comments) {
        this.tags = tags;
        this.content = content;
        this.owner = owner;
        this.badges = badges;
        this.image = image;
        this.likes = likes;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }
}
