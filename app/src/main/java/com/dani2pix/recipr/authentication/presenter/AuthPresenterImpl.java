package com.dani2pix.recipr.authentication.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.dani2pix.recipr.api.AuthApiConstants;
import com.dani2pix.recipr.api.NetworkService;
import com.dani2pix.recipr.authentication.view.AuthView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import static com.dani2pix.recipr.api.AuthApiConstants.API_KEY;
import static com.dani2pix.recipr.api.AuthApiConstants.CREATE_SESSION;


/**
 * Created by Domnica on 1/30/2017.
 */

public class AuthPresenterImpl implements AuthPresenter {

    private WeakReference<AuthView> view;
    private NetworkService networkService;

    @Inject
    Context context;

    @Inject
    public AuthPresenterImpl(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void fetchToken() {
        networkService.fetchRequestToken(new NetworkService.AuthCallback() {
            @Override
            public void onSuccess() {
                //view.get().onTokenRequestSuccess();
            }

            @Override
            public void onError() {
                view.get().onTokenRequestFailure();
            }
        }, new NetworkService.AuthCallback.TokenCallback() {
            @Override
            public void onTokenRetrieved(String token) {
               // view.get().onTokenRequestSuccess(token);
                fetchSession(token);
            }
        });
    }

    @Override
    public void fetchSession(String token) {
        networkService.fetchSession(new NetworkService.AuthCallback() {
            @Override
            public void onSuccess() {
                view.get().onAuthenticationSuccess();
            }

            @Override
            public void onError() {
                view.get().onAuthenticationSuccess();
            }
        }, token);
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
