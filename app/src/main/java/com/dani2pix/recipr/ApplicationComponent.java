package com.dani2pix.recipr;

import com.dani2pix.recipr.api.NetworkServiceImpl;
import com.dani2pix.recipr.authentication.presenter.AuthPresenterImpl;
import com.dani2pix.recipr.authentication.view.AuthFragment;
import com.dani2pix.recipr.splashscreen.SplashScreen;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Domnica on 1/28/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(ReciprApplication target);
    void inject(SplashScreen target);
    void inject(AuthPresenterImpl target);
    void inject(AuthFragment target);
    void inject(NetworkServiceImpl target);

}
