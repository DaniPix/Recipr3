package com.dani2pix.recipr.api.http;

import android.util.Log;

import com.dani2pix.recipr.api.ApiConstants;
import com.dani2pix.recipr.api.ApiService;
import com.dani2pix.recipr.authentication.model.GuestSession;
import com.dani2pix.recipr.authentication.model.Token;
import com.dani2pix.recipr.authentication.model.Session;
import com.dani2pix.recipr.authentication.model.ValidatedToken;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 1/30/2017.
 */

public class AuthServiceImpl implements AuthService {

    private ApiService networkService;
    private Token token;
    private ValidatedToken validatedToken;
    private Session session;
    private GuestSession guestSession;

    @Inject
    public AuthServiceImpl(ApiService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void fetchToken(final AuthCallback authCallback) {
        Observable<Token> observable = networkService.requestToken(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Token>() {
                    @Override
                    public void onCompleted() {
                        authCallback.onTokenReceived(token.getRequestToken());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        authCallback.onError();
                    }

                    @Override
                    public void onNext(Token newToken) {
                        token = newToken;
                    }
                });
    }

    @Override
    public void validateToken(final AuthCallback authCallback, String username, String password, String token) {
        Observable<ValidatedToken> observable = networkService.requestTokenValidation(ApiConstants.API_KEY, username, password, token);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ValidatedToken>() {
                    @Override
                    public void onCompleted() {
                        authCallback.onTokenValidated(validatedToken.getRequestToken());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        authCallback.onError();
                    }

                    @Override
                    public void onNext(ValidatedToken newValidatedToken) {
                        validatedToken = newValidatedToken;
                    }
                });
    }

    @Override
    public void fetchSession(final AuthCallback authCallback, String validatedToken) {
        Observable<Session> observable = networkService.requestSession(ApiConstants.API_KEY, validatedToken);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Session>() {
                    @Override
                    public void onCompleted() {
                        authCallback.onSessionReceived(session.getSessionId());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        authCallback.onError();
                    }

                    @Override
                    public void onNext(Session newSession) {
                        session = newSession;
                    }
                });
    }

    @Override
    public void fetchGuestSession(final AuthCallback authCallback) {
        Observable<GuestSession> observable = networkService.requestGuestSession(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GuestSession>() {
                    @Override
                    public void onCompleted() {
                        authCallback.onGuestSessionReceived(guestSession.getGuestSessionId());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        authCallback.onError();
                    }

                    @Override
                    public void onNext(GuestSession newGuestSession) {
                        guestSession = newGuestSession;
                    }
                });
    }
}
