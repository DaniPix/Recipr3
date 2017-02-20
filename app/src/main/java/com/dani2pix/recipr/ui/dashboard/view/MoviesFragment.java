package com.dani2pix.recipr.ui.dashboard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.ui.dashboard.adapter.DashboardAdapter;
import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;
import com.dani2pix.recipr.ui.dashboard.presenter.MoviesPresenter;

import javax.inject.Inject;

/**
 * Created by Domnica on 2/19/2017.
 */

public class MoviesFragment extends DashboardFragment implements DashboardView {


    @Inject
    MoviesPresenter presenter;

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
                presenter.exploreMovies();
            }
        });


        presenter.exploreMovies();
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
    public void onMoviesReceived(DiscoverMedia discoverMedia) {
        DashboardAdapter adapter = new DashboardAdapter<>(discoverMedia.getResults(), context);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context));
        swipeRefreshList.setRefreshing(false);
    }

    @Override
    public void onTvShowsReceived(DiscoverMedia discoverMedia) {
        // do nothing
    }

    @Override
    public void onPopularPeopleReceived(DiscoverMedia discoverMedia) {
        // do nothing
    }

    @Override
    public void onError() {
        Toast.makeText(context, R.string.general_error_message, Toast.LENGTH_SHORT).show();
    }
}
