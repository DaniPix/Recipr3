package com.dani2pix.recipr;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dani2pix.recipr.authentication.presenter.AuthPresenter;
import com.dani2pix.recipr.authentication.presenter.AuthPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Domnica on 1/28/2017.
 */


@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
