package com.dani2pix.recipr.ui.dashboard.view;

import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;
import com.dani2pix.recipr.ui.view.View;

/**
 * Created by Domnica on 2/12/2017.
 */

public interface DashboardView extends View {

    void onMoviesReceived(DiscoverMedia discoverMedia);

    void onTvShowsReceived(DiscoverMedia discoverMedia);

    void onPopularPeopleReceived(DiscoverMedia discoverMedia);

    void onError();

}
