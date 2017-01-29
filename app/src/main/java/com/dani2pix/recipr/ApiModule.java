package com.dani2pix.recipr;

import android.content.Context;

import com.dani2pix.recipr.api.AuthApiConstants;
import com.dani2pix.recipr.api.AuthApiService;

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
                .baseUrl(AuthApiConstants.BASE_ENDPOINT + "/" + AuthApiConstants.API_KEY + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
