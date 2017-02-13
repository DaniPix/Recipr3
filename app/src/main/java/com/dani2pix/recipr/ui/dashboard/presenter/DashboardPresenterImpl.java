package com.dani2pix.recipr.ui.dashboard.presenter;

import com.dani2pix.recipr.ui.dashboard.view.DashboardView;

import java.lang.ref.WeakReference;

/**
 * Created by Domnica on 2/12/2017.
 */

public class DashboardPresenterImpl implements DashboardPresenter {

    private WeakReference<DashboardView> view;

    @Override
    public void search() {

    }

    @Override
    public void explore() {

    }

    @Override
    public void exploreMovies() {

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
