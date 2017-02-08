package com.dani2pix.recipr.api;

import android.util.Log;

import com.dani2pix.recipr.authentication.model.RequestToken;
import com.dani2pix.recipr.authentication.model.Session;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 1/30/2017.
 */

public class NetworkServiceImpl implements NetworkService {

    private AuthApiService networkService;

    @Inject
    public NetworkServiceImpl(AuthApiService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void fetchRequestToken(final AuthCallback authCallback, final AuthCallback.TokenCallback tokenCallback) {
        Observable<RequestToken> observable = networkService.requestToken(AuthApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RequestToken>() {
                    @Override
                    public void onCompleted() {
                        authCallback.onSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        authCallback.onError();
                    }

                    @Override
                    public void onNext(RequestToken requestTokenModel) {
                        tokenCallback.onTokenRetrieved(requestTokenModel.getRequestToken());
                    }
                });
    }

    @Override
    public void fetchSession(final AuthCallback callback, String requestToken) {
        Observable<Session> observable = networkService.requestSession(AuthApiConstants.API_KEY, requestToken);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Session>() {
                    @Override
                    public void onCompleted() {
                        callback.onSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        callback.onError();
                    }

                    @Override
                    public void onNext(Session session) {
                        // Don't do anything with it yet
                    }
                });
    }
}
