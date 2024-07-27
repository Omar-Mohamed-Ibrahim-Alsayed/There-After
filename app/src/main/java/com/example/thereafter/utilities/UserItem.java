package com.example.thereafter.utilities;

public class UserItem {
    private String name;
    private Integer id;
    private String badges;
    private String image;
    private Number rate;
    private Number sermons;
    private Number posts;

    public UserItem(String name, Integer id, String badges, String image, Number rate, Number sermons, Number posts) {
        this.name = name;
        this.id = id;
        this.badges = badges;
        this.image = image;
        this.rate = rate;
        this.sermons = sermons;
        this.posts = posts;
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

    public Number getRate() {
        return rate;
    }

    public void setRate(Number rate) {
        this.rate = rate;
    }

    public Number getSermons() {
        return sermons;
    }

    public void setSermons(Number sermons) {
        this.sermons = sermons;
    }

    public Number getPosts() {
        return posts;
    }

    public void setPosts(Number posts) {
        this.posts = posts;
    }
}
