package com.dani2pix.recipr.authentication.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.api.AuthApiConstants;
import com.dani2pix.recipr.api.AuthApiService;
import com.dani2pix.recipr.authentication.model.RequestTokenModel;
import com.dani2pix.recipr.authentication.view.AuthView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 1/30/2017.
 */

public class AuthPresenterImpl implements AuthPresenter {

    private WeakReference<AuthView> view;
    private Subscription subscription;

    private RequestTokenModel requestToken;

    private Retrofit retrofit;

    @Inject
    public AuthPresenterImpl(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    @Override
    public void beginAuthenticationProcess() {
        Observable<RequestTokenModel> observable = retrofit.create(AuthApiService.class).requestToken(AuthApiConstants.API_KEY);
        subscription = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RequestTokenModel>() {
                    @Override
                    public void onCompleted() {
                        view.get().onAuthenticationSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        view.get().onAuthenticationFailure();
                    }

                    @Override
                    public void onNext(RequestTokenModel requestTokenModel) {
                        requestToken = requestTokenModel;
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
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
