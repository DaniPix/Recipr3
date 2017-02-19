package com.dani2pix.recipr.ui.dashboard.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShows;
import com.dani2pix.recipr.ui.dashboard.presenter.ShowsPresenter;

import javax.inject.Inject;

/**
 * Created by Domnica on 2/19/2017.
 */

public class ShowsFragment extends DashboardFragment implements DashboardView {

    @Inject
    ShowsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        swipeRefreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshList.setRefreshing(true);
                presenter.exploreTvShows();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void onMoviesReceived(Movies movies) {
       // do nothing
    }

    @Override
    public void onTvShowsReceived(TvShows shows) {
        Toast.makeText(context, "Shows received.", Toast.LENGTH_SHORT).show();
        swipeRefreshList.setRefreshing(false);
    }

    @Override
    public void onPopularPeopleReceived(People people) {
        // do nothing
    }

    @Override
    public void onError() {
        Toast.makeText(context, R.string.general_error_message, Toast.LENGTH_SHORT).show();
    }
}
