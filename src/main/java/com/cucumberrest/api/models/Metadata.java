package com.cucumberrest.api.models;

import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("id")
    private String id;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("private")
    private boolean isPrivate;

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}