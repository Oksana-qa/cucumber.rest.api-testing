package com.cucumberrest.api.models;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("city")
    private String city;

    @SerializedName("address")
    private String address;

    public Location(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

}