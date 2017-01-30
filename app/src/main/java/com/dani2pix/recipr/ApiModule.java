package com.dani2pix.recipr;


import com.dani2pix.recipr.api.AuthApiConstants;
import com.dani2pix.recipr.api.AuthApiService;
import com.dani2pix.recipr.api.NetworkService;
import com.dani2pix.recipr.api.NetworkServiceImpl;
import com.dani2pix.recipr.authentication.presenter.AuthPresenter;
import com.dani2pix.recipr.authentication.presenter.AuthPresenterImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Domnica on 1/29/2017.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AuthApiConstants.BASE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    public AuthApiService provideAuthApiService(Retrofit retrofit) {
        return retrofit.create(AuthApiService.class);
    }


    @Provides
    @Singleton
    public NetworkService providesNetworkService(AuthApiService networkService) {
        return new NetworkServiceImpl(networkService);
    }

    @Provides
    @Singleton
    public AuthPresenter provideAuthPresenter(NetworkService networkService) {
        return new AuthPresenterImpl(networkService);
    }

}
