package com.dani2pix.recipr.ui.authentication.presenter;

import com.dani2pix.recipr.api.http.AuthService;
import com.dani2pix.recipr.ui.authentication.view.AuthView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;


/**
 * Created by Domnica on 1/30/2017.
 */

public class AuthPresenterImpl implements AuthPresenter {

    private WeakReference<AuthView> view;
    private AuthService authService;

    @Inject
    public AuthPresenterImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void attachView(AuthView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void fetchToken() {
        authService.fetchToken(new AuthService.AuthCallback() {
            @Override
            public void onTokenReceived(String token) {
                view.get().onTokenReceived(token);
            }

            @Override
            public void onError() {
                view.get().onAuthenticationFailure();
            }
        });
    }

    @Override
    public void validateToken(String username, String password, String token) {
        authService.validateToken(new AuthService.AuthCallback() {
            @Override
            public void onTokenValidated(String validatedToken) {
                view.get().onTokenValidated(validatedToken);
            }

            @Override
            public void onError() {
                view.get().onAuthenticationFailure();
            }

        }, username, password, token);
    }

    @Override
    public void fetchSession(String validatedToken) {
        authService.fetchSession(new AuthService.AuthCallback() {
            @Override
            public void onSessionReceived(String session) {
                view.get().onSessionReceived(session);
            }

            @Override
            public void onError() {
                view.get().onAuthenticationFailure();
            }

        }, validatedToken);
    }

    @Override
    public void fetchGuestSession() {
        authService.fetchGuestSession(new AuthService.AuthCallback() {
            @Override
            public void onGuestSessionReceived(String guestSession) {
                view.get().onGuessSessionReceived(guestSession);
            }

            @Override
            public void onError() {
                view.get().onAuthenticationFailure();
            }
        });

    }
}
