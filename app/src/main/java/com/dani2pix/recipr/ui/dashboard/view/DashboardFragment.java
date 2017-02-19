package com.dani2pix.recipr.ui.dashboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domnica on 2/12/2017.
 */

public class DashboardFragment extends Fragment {

    @Inject
    Context context;

    @BindView(R.id.dashboardList)
    RecyclerView list;
    @BindView(R.id.dashboardSwipeList)
    SwipeRefreshLayout swipeRefreshList;


    public DashboardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
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

        return view;
    }
}
