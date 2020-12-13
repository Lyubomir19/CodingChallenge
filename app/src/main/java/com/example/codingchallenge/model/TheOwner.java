package com.example.codingchallenge.model;

public class TheOwner {

    private String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public TheOwner(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
