package com.dani2pix.recipr.authentication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domnica on 1/28/2017.
 */

public class Session {

    @SerializedName("success")
    private boolean success;
    @SerializedName("session_id")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public boolean isSuccess() {
        return success;
    }
}
