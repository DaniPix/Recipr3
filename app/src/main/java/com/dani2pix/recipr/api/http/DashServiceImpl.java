package com.dani2pix.recipr.api.http;

import android.util.Log;

import com.dani2pix.recipr.api.ApiConstants;
import com.dani2pix.recipr.api.ApiService;
import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.Movie;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;

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
        Observable<DiscoverMedia<Movie>> observable = networkService.exploreMovies(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DiscoverMedia<Movie>>() {
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
                    public void onNext(DiscoverMedia<Movie> discoverMedia) {
                        dashCallback.onMoviesResponse(discoverMedia);
                    }
                });
    }

    @Override
    public void exploreTvShows(final DashCallback dashCallback) {
        Observable<DiscoverMedia<TvShow>> observable = networkService.exploreTvShows(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DiscoverMedia<TvShow>>() {
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
                    public void onNext(DiscoverMedia<TvShow> shows) {
                        dashCallback.onTvShowsResponse(shows);
                    }
                });
    }

    @Override
    public void explorePeople(final DashCallback dashCallback) {
        Observable<DiscoverMedia<People>> observable = networkService.explorePopularPeople(ApiConstants.API_KEY);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DiscoverMedia<People>>() {
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
                    public void onNext(DiscoverMedia<People> people) {
                        dashCallback.onPeopleResponse(people);
                    }
                });
    }
}
