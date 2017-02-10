package com.dani2pix.recipr;

import android.app.Application;

/**
 * Created by Domnica on 1/28/2017.
 */

public class ReciprApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();


        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();
    }


    public ApplicationComponent getComponent() {
        return component;
    }
}
