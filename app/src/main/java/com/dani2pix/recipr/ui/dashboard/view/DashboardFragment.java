package com.dani2pix.recipr.ui.dashboard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.ui.dashboard.presenter.DashboardPresenter;

import javax.inject.Inject;

/**
 * Created by Domnica on 2/12/2017.
 */

public class DashboardFragment extends Fragment implements DashboardView {

    private static final String ARG_SECTION_NUMBER = "section_number";

    @Inject
    DashboardPresenter presenter;

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
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
    public void onSearchDataReceived() {

    }

    @Override
    public void onExplorationDataReceived() {

    }

    @Override
    public void onMoviesExplorationDataReceived() {

    }

    @Override
    public void onTvShowsExplorationDataReceived() {

    }

    @Override
    public void onPeopleExplorationDataReceived() {

    }
}
