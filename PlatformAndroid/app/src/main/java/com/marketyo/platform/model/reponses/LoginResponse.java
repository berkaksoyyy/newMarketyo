package com.marketyo.platform.model.reponses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("token")
    private String token;

    public Boolean getSuccess() {
        return success != null && success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
