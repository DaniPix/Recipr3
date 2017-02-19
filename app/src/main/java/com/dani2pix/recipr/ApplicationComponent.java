package com.dani2pix.recipr;

import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenterImpl;
import com.dani2pix.recipr.ui.authentication.view.AuthActivity;
import com.dani2pix.recipr.ui.authentication.view.AuthFragment;
import com.dani2pix.recipr.ui.dashboard.adapter.DashboardAdapter;
import com.dani2pix.recipr.ui.dashboard.presenter.DashboardPresenter;
import com.dani2pix.recipr.ui.dashboard.presenter.DashboardPresenterImpl;
import com.dani2pix.recipr.ui.dashboard.view.DashActivity;
import com.dani2pix.recipr.ui.dashboard.view.DashboardFragment;
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

    void inject(DashboardPresenterImpl target);

    void inject(DashboardFragment target);
}
