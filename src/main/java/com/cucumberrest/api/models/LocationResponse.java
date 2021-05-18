package com.cucumberrest.api.models;

import com.google.gson.annotations.SerializedName;

public class LocationResponse {
    @SerializedName("record")
    private Location location;

    @SerializedName("metadata")
    private Metadata metadata;

    public Location getLocation() {
        return location;
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
