package com.dani2pix.recipr.ui.dashboard.view;

import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.Movie;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;
import com.dani2pix.recipr.ui.view.View;

/**
 * Created by Domnica on 2/12/2017.
 */

public interface DashboardView extends View {

    void onMoviesReceived(DiscoverMedia<Movie> discoverMedia);

    void onTvShowsReceived(DiscoverMedia<TvShow> discoverMedia);

    void onPopularPeopleReceived(DiscoverMedia<People> discoverMedia);

    void onError();

}
