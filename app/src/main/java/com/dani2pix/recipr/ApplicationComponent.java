package com.dani2pix.recipr;

import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenterImpl;
import com.dani2pix.recipr.ui.authentication.view.AuthFragment;
import com.dani2pix.recipr.ui.dashboard.presenter.MoviePresenterImpl;
import com.dani2pix.recipr.ui.dashboard.presenter.PeoplePresenterImpl;
import com.dani2pix.recipr.ui.dashboard.presenter.ShowsPresenterImpl;
import com.dani2pix.recipr.ui.dashboard.view.DashActivity;
import com.dani2pix.recipr.ui.dashboard.view.DashboardFragment;
import com.dani2pix.recipr.ui.dashboard.view.MoviesFragment;
import com.dani2pix.recipr.ui.dashboard.view.PeopleFragment;
import com.dani2pix.recipr.ui.dashboard.view.ShowsFragment;
import com.dani2pix.recipr.ui.details.view.DetailsScreenFragment;
import com.dani2pix.recipr.ui.splashscreen.SplashScreen;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Domnica on 1/28/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(ReciprApplication target);

    void inject(AuthPresenterImpl target);

    void inject(AuthFragment target);

    void inject(DashActivity target);

    void inject(SplashScreen target);

    void inject(MoviePresenterImpl target);

    void inject(ShowsPresenterImpl target);

    void inject(PeoplePresenterImpl target);

    void inject(DashboardFragment target);

    void inject(MoviesFragment target);

    void inject(ShowsFragment target);

    void inject(PeopleFragment target);

    void inject(DetailsScreenFragment target);
}
