package com.dani2pix.recipr.authentication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domnica on 1/28/2017.
 */

public class GuestSessionModel {

    @SerializedName("success")
    private boolean success;
    @SerializedName("guest_session_id")
    private String guestSessionId;
    @SerializedName("expires_at")
    private String expirationDate;

    public boolean isSuccess() {
        return success;
    }

    public String getGuestSessionId() {
        return guestSessionId;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

}
