package com.example.thereafter.utilities;

public class PostItem {
    private Integer id;
    private String tags;
    private String content;
    private String owner;
    private String badges;
    private String image;
    private Number likes;
    private Number comments;

    public PostItem(Integer id, String tags, String content, String owner, String badges, String image, Number likes, Number dislikes, Number comments) {
        this.id = id;
        this.tags = tags;
        this.content = content;
        this.owner = owner;
        this.badges = badges;
        this.image = image;
        this.likes = likes;
        this.comments = comments;
    }

    public Number getLikes() {
        return likes;
    }

    public void setLikes(Number likes) {
        this.likes = likes;
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

    public Number getComments() {
        return comments;
    }

    public void setComments(Number comments) {
        this.comments = comments;
    }
}
