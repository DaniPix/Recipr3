package com.dani2pix.recipr.authentication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domnica on 1/28/2017.
 */

public class ValidateToken {

    @SerializedName("success")
    private boolean success;
    @SerializedName("request_token")
    private String requestToken;

    public boolean isSuccess() {
        return success;
    }

    public String getRequestToken() {
        return requestToken;
    }
}
