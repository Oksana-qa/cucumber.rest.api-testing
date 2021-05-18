package com.cucumberrest.api.models;

import com.google.gson.annotations.SerializedName;

public class DeleteResponse {

    @SerializedName("metadata")
    private DeleteMetadata metadata;

    @SerializedName("message")
    private String message;

    public DeleteMetadata getMetadata() {
        return metadata;
    }

    public String getMessage() {
        return message;
    }
}

