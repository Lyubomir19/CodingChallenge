package com.example.codingchallenge.model;


import com.google.gson.annotations.SerializedName;

public class Repo {

    // First Object fields
    private String id;
    private String node_id;
    private String name;
    private String full_name;
    @SerializedName("private")
    private String private_name;
    private String description;

    // Here we are entering the nested object to get the image field
    @SerializedName("owner")
    private TheOwner owner;

    public Repo(String id, String node_id, String name, String full_name, String private_name, String description, TheOwner owner) {
        this.id = id;
        this.node_id = node_id;
        this.name = name;
        this.full_name = full_name;
        this.private_name = private_name;
        this.description = description;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPrivate_name() {
        return private_name;
    }

    public void setPrivate_name(String private_name) {
        this.private_name = private_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TheOwner getOwner() {
        return owner;
    }

    public void setOwner(TheOwner owner) {
        this.owner = owner;
    }
}



