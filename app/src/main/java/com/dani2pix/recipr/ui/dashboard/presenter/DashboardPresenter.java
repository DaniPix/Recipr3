package com.dani2pix.recipr.ui.dashboard.presenter;

import com.dani2pix.recipr.ui.dashboard.view.DashboardView;
import com.dani2pix.recipr.ui.presenter.Presenter;

/**
 * Created by Domnica on 2/12/2017.
 */

public interface DashboardPresenter extends Presenter<DashboardView> {
    void exploreMovies();

    void exploreTvShows();

    void explorePeople();
}
