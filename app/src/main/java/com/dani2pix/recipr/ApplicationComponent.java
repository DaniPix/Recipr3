package com.dani2pix.recipr;

import com.dani2pix.recipr.authentication.presenter.AuthPresenterImpl;
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

}
