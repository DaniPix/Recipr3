package com.dani2pix.recipr;

import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenterImpl;
import com.dani2pix.recipr.ui.authentication.view.AuthActivity;
import com.dani2pix.recipr.ui.authentication.view.AuthFragment;
import com.dani2pix.recipr.ui.dashboard.view.DashActivity;

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

    void inject(AuthActivity target);

    void inject(AuthFragment target);

    void inject(DashActivity target);
}
