package com.dani2pix.recipr.api.http;

import android.util.Log;

import com.dani2pix.recipr.api.ApiConstants;
import com.dani2pix.recipr.api.ApiService;
import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShows;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Domnica on 2/18/2017.
 */

public class DashServiceImpl implements DashService {

    private ApiService networkService;

    @Inject
    public DashServiceImpl(ApiService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void exploreMovies(final DashCallback dashCallback) {
        Observable<Movies> observable = networkService.exploreMovies(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Movies>() {
                    @Override
                    public void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        dashCallback.onError();
                    }

                    @Override
                    public void onNext(Movies movies) {
                        dashCallback.onMoviesResponse(movies);
                    }
                });
    }

    @Override
    public void exploreTvShows(final DashCallback dashCallback) {
        Observable<TvShows> observable = networkService.exploreTvShows(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TvShows>() {
                    @Override
                    public void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        dashCallback.onError();
                    }

                    @Override
                    public void onNext(TvShows shows) {
                        dashCallback.onTvShowsResponse(shows);
                    }
                });
    }

    @Override
    public void explorePeople(final DashCallback dashCallback) {
        Observable<People> observable = networkService.explorePopularPeople(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<People>() {
                    @Override
                    public void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        dashCallback.onError();
                    }

                    @Override
                    public void onNext(People people) {
                        dashCallback.onPeopleResponse(people);
                    }
                });
    }
}
