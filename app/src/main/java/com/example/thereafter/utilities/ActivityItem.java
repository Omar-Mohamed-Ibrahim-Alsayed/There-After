package com.example.thereafter.utilities;

public class ActivityItem {
    private String name;
    private Integer id;
    private String tags;
    private String description;
    private String owner;
    private String image;
    private Number followers;
    private String date;
    private String certification;

    public ActivityItem(String name, Integer id, String tags, String description, String owner, String image, Number followers, String date, String certification) {
        this.name = name;
        this.id = id;
        this.tags = tags;
        this.description = description;
        this.owner = owner;
        this.image = image;
        this.followers = followers;
        this.date = date;
        this.certification = certification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
