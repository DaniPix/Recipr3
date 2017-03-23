package com.dani2pix.recipr;


import com.dani2pix.recipr.api.ApiConstants;
import com.dani2pix.recipr.api.ApiService;
import com.dani2pix.recipr.api.http.AuthService;
import com.dani2pix.recipr.api.http.AuthServiceImpl;
import com.dani2pix.recipr.api.http.DashService;
import com.dani2pix.recipr.api.http.DashServiceImpl;
import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenter;
import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenterImpl;
import com.dani2pix.recipr.ui.dashboard.presenter.MoviePresenterImpl;
import com.dani2pix.recipr.ui.dashboard.presenter.MoviesPresenter;
import com.dani2pix.recipr.ui.dashboard.presenter.PeoplePresenter;
import com.dani2pix.recipr.ui.dashboard.presenter.PeoplePresenterImpl;
import com.dani2pix.recipr.ui.dashboard.presenter.ShowsPresenter;
import com.dani2pix.recipr.ui.dashboard.presenter.ShowsPresenterImpl;

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
        //dsada
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

    @Provides
    @Singleton
    public DashService providesDashService(ApiService apiService) {
        return new DashServiceImpl(apiService);
    }

    @Provides
    @Singleton
    public MoviesPresenter provideMoviePresenter(DashService dashService) {
        return new MoviePresenterImpl(dashService);
    }

    @Provides
    @Singleton
    public ShowsPresenter provideShowsPresenter(DashService dashService) {
        return new ShowsPresenterImpl(dashService);
    }

    @Provides
    @Singleton
    public PeoplePresenter providePeoplePresenter(DashService dashService) {
        return new PeoplePresenterImpl(dashService);
    }
}
