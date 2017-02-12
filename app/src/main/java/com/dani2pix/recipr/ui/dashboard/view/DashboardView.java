package com.dani2pix.recipr.ui.dashboard.view;

import com.dani2pix.recipr.ui.view.View;

/**
 * Created by Domnica on 2/12/2017.
 */

public interface DashboardView extends View {

    void onSearchDataReceived();

    void onExplorationDataReceived();

    void onMoviesExplorationDataReceived();

    void onTvShowsExplorationDataReceived();

    void onPeopleExplorationDataReceived();

}
