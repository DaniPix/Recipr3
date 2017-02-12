package com.dani2pix.recipr;


import com.dani2pix.recipr.api.ApiConstants;
import com.dani2pix.recipr.api.ApiService;
import com.dani2pix.recipr.api.http.AuthService;
import com.dani2pix.recipr.api.http.AuthServiceImpl;
import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenter;
import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenterImpl;

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
                .baseUrl(ApiConstants.BASE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideAuthApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


    @Provides
    @Singleton
    public AuthService providesAuthService(ApiService apiService) {
        return new AuthServiceImpl(apiService);
    }

    @Provides
    @Singleton
    public AuthPresenter provideAuthPresenter(AuthService authService) {
        return new AuthPresenterImpl(authService);
    }
}
