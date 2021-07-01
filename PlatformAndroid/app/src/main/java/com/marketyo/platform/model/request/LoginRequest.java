package com.marketyo.platform.model.request;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("password")
    private String mPassword;
    @SerializedName("username")
    private String mUsername;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
