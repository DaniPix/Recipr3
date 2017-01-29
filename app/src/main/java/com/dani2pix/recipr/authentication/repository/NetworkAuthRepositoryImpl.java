package com.dani2pix.recipr.authentication.repository;

import com.dani2pix.recipr.api.AuthApiConstants;
import com.dani2pix.recipr.api.AuthApiService;
import com.dani2pix.recipr.authentication.model.GuestSessionModel;
import com.dani2pix.recipr.authentication.model.RequestTokenModel;
import com.dani2pix.recipr.authentication.model.SessionModel;
import com.dani2pix.recipr.authentication.model.ValidateTokenModel;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 1/28/2017.
 */

public class NetworkAuthRepositoryImpl implements AuthRepository {



    private RequestTokenModel requestToken;


    @Override
    public GuestSessionModel getGuessSession() {
        return null;
    }

    @Override
    public SessionModel getSession() {
        return null;
    }

    @Override
    public RequestTokenModel getRequestToken() {

        return null;
    }

    @Override
    public ValidateTokenModel getValidateToken() {
        return null;
    }
}
