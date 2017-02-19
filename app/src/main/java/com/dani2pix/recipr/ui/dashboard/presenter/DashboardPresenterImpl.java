package com.dani2pix.recipr.ui.dashboard.presenter;

import com.dani2pix.recipr.api.http.DashService;
import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.view.DashboardView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by Domnica on 2/12/2017.
 */

public class DashboardPresenterImpl implements DashboardPresenter {

    private WeakReference<DashboardView> view;
    private DashService dashService;

    @Inject
    public DashboardPresenterImpl(DashService dashService){
        this.dashService = dashService;
    }

    @Override
    public void exploreMovies() {
        dashService.exploreMovies(new DashService.DashCallback() {
            @Override
            public void onMoviesResponse(Movies response) {
                view.get().onMoviesReceived(response);
            }

            @Override
            public void onError() {
                view.get().onError();
            }
        });
    }

    @Override
    public void exploreTvShows() {

    }

    @Override
    public void explorePeople() {

    }


    @Override
    public void attachView(DashboardView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
