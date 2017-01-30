package com.dani2pix.recipr.authentication.presenter;


import com.dani2pix.recipr.api.NetworkServiceImpl;
import com.dani2pix.recipr.authentication.model.RequestTokenModel;
import com.dani2pix.recipr.authentication.view.AuthView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


/**
 * Created by Domnica on 1/30/2017.
 */

public class AuthPresenterImpl implements AuthPresenter {

    private WeakReference<AuthView> view;


    NetworkServiceImpl networkService;

    @Inject
    public AuthPresenterImpl(NetworkServiceImpl networkService){
        this.networkService = networkService;
    }

    @Override
    public void beginAuthenticationProcess() {
        networkService.fetchRequestToken(new NetworkServiceImpl.RequestTokenCallback() {
            @Override
            public void onTokenReceived(RequestTokenModel requestToken) {
               // dont care
            }

            @Override
            public void onSuccess() {
                view.get().onAuthenticationSuccess();
            }

            @Override
            public void onError() {
                view.get().onAuthenticationFailure();
            }
        });
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
