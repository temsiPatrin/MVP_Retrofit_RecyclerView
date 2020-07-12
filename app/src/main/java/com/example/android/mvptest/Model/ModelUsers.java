package com.example.android.mvptest.Model;

import com.google.gson.annotations.SerializedName;

public class ModelUsers {

    @SerializedName("id")
    String userId;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String userName;
    @SerializedName("email")
    String userEmail;
    @SerializedName("website")
    String website;

    public ModelUsers(String userId, String name, String userName, String userEmail, String website) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.website = website;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getWebsite() {
        return website;
    }
}
