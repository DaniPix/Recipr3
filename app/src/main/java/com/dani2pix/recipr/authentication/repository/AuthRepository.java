package com.dani2pix.recipr.authentication.repository;

import com.dani2pix.recipr.authentication.model.GuestSessionModel;
import com.dani2pix.recipr.authentication.model.RequestTokenModel;
import com.dani2pix.recipr.authentication.model.SessionModel;
import com.dani2pix.recipr.authentication.model.ValidateTokenModel;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthRepository {

    GuestSessionModel getGuessSession();

    SessionModel getSession();

    RequestTokenModel getRequestToken();

    ValidateTokenModel getValidateToken();

}
