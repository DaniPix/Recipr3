package com.dani2pix.recipr.api.http;

import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShows;

/**
 * Created by Domnica on 2/18/2017.
 */

public interface DashService {

    void exploreMovies(DashCallback callback);

    void exploreTvShows(DashCallback callback);

    void explorePeople(DashCallback callback);


    abstract class DashCallback {
        public void onMoviesResponse(Movies response) {

        }

        public void onTvShowsResponse(TvShows response) {

        }

        public void onPeopleResponse(People response) {

        }

        public void onError() {

        }
    }
}
