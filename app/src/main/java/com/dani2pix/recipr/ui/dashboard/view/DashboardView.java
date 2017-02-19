package com.dani2pix.recipr.ui.dashboard.view;

import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShows;
import com.dani2pix.recipr.ui.view.View;

/**
 * Created by Domnica on 2/12/2017.
 */

public interface DashboardView extends View {

    void onMoviesReceived(Movies movies);

    void onTvShowsReceived(TvShows shows);

    void onPopularPeopleReceived(People people);

    void onError();

}
