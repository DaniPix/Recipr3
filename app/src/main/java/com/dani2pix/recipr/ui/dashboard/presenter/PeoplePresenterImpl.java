package com.dani2pix.recipr.ui.dashboard.presenter;

import com.dani2pix.recipr.api.http.DashService;
import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.view.DashboardView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by Domnica on 2/19/2017.
 */

public class PeoplePresenterImpl implements PeoplePresenter {

    private WeakReference<DashboardView> view;
    private DashService dashService;

    @Inject
    public PeoplePresenterImpl(DashService dashService) {
        this.dashService = dashService;
    }

    @Override
    public void explorePeople() {
        dashService.explorePeople(new DashService.DashCallback() {
            @Override
            public void onPeopleResponse(DiscoverMedia<People> response) {
                view.get().onPopularPeopleReceived(response);
            }

            @Override
            public void onError() {
                view.get().onError();
            }
        });
    }

    @Override
    public void attachView(DashboardView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
