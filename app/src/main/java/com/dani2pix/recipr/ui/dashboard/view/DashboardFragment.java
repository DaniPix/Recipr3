package com.dani2pix.recipr.ui.dashboard.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.ui.dashboard.adapter.DashboardAdapter;
import com.dani2pix.recipr.ui.dashboard.model.Movies;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShows;
import com.dani2pix.recipr.ui.dashboard.presenter.DashboardPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domnica on 2/12/2017.
 */

public class DashboardFragment extends Fragment implements DashboardView {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private Movies movies;
    private TvShows shows;
    private People people;

    private DashboardAdapter adapter;

    @Inject
    DashboardPresenter presenter;
    @Inject
    Context context;

    @BindView(R.id.dashboardList)
    RecyclerView list;
    @BindView(R.id.dashboardSwipeList)
    SwipeRefreshLayout swipeRefreshList;

    public DashboardFragment() {

    }

    public DashboardFragment newInstance(int sectionNumber) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
        presenter.attachView(this);
        presenter.exploreMovies();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        swipeRefreshList.setColorSchemeColors(
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorAccent)
        );

        swipeRefreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                    presenter.exploreMovies();

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
        adapter = new DashboardAdapter(movies.getResults(), context);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context));
        swipeRefreshList.setRefreshing(false);
    }

    @Override
    public void onTvShowsReceived() {

    }

    @Override
    public void onPopularPeopleReceived() {

    }

    @Override
    public void onError() {
        Toast.makeText(context, R.string.general_error_message, Toast.LENGTH_SHORT).show();
    }
}
