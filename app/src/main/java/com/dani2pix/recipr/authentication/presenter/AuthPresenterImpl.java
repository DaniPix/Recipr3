package com.dani2pix.recipr.authentication.presenter;

import com.dani2pix.recipr.authentication.model.GuestSessionModel;
import com.dani2pix.recipr.authentication.model.RequestTokenModel;
import com.dani2pix.recipr.authentication.model.SessionModel;
import com.dani2pix.recipr.authentication.model.ValidateTokenModel;
import com.dani2pix.recipr.authentication.repository.AuthRepository;
import com.dani2pix.recipr.authentication.view.AuthView;

import java.lang.ref.WeakReference;

/**
 * Created by Domnica on 1/28/2017.
 */

public class AuthPresenterImpl implements AuthPresenter {



    private WeakReference<AuthView> view;
    private AuthRepository authRepository;

    private GuestSessionModel guestSession;
    private SessionModel session;
    private RequestTokenModel requestToken;
    private ValidateTokenModel validateToken;

    @Override
    public void beingAuthenticationProcess() {

    }

    @Override
    public void attachView(AuthView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
