package com.example.thereafter.utilities;

public class Sermon {

    private String name;
    private Integer id;
    private String category;
    private String content;
    private String owner;
    private String badges;
    private String image;
    private Number rate;

    public Sermon(String name, Integer id, String image, String category, String content, Number rate, String owner, String badges) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.category = category;
        this.content = content;
        this.rate = rate;
        this.owner = owner;
        this.badges = badges;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getcategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Number getRate() {
        return rate;
    }

    public void setRate(Number rate) {
        this.rate = rate;
    }
}
