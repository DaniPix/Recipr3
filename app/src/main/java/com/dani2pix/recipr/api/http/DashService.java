package com.dani2pix.recipr.api.http;

import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;

/**
 * Created by Domnica on 2/18/2017.
 */

public interface DashService {

    void exploreMovies(DashCallback callback);

    void exploreTvShows(DashCallback callback);

    void explorePeople(DashCallback callback);


    abstract class DashCallback {
        public void onMoviesResponse(DiscoverMedia response) {

        }

        public void onTvShowsResponse(DiscoverMedia response) {

        }

        public void onPeopleResponse(DiscoverMedia response) {

        }

        public void onError() {

        }
    }
}
