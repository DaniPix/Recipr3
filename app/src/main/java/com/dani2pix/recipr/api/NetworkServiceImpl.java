package com.dani2pix.recipr.api;

import android.util.Log;

import com.dani2pix.recipr.authentication.model.RequestTokenModel;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 1/30/2017.
 */

public class NetworkServiceImpl {


    private AuthApiService networkService;

    @Inject
    public NetworkServiceImpl(AuthApiService networkService) {
        this.networkService = networkService;
    }

    public Subscription fetchRequestToken(final RequestTokenCallback callback) {
        Observable<RequestTokenModel> observable = networkService.requestToken(AuthApiConstants.API_KEY);
        return observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RequestTokenModel>() {
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
                    public void onNext(RequestTokenModel requestTokenModel) {
                        callback.onTokenReceived(requestTokenModel);
                    }
                });
    }


    public interface RequestTokenCallback {
        void onTokenReceived(RequestTokenModel requestToken);

        void onSuccess();

        void onError();
    }
}
