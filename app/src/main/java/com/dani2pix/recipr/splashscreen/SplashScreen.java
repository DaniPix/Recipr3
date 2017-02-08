package com.dani2pix.recipr.splashscreen;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.authentication.view.AuthFragment;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startAuthFragment();
    }


    private void startAuthFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentByTag(AuthFragment.class.getSimpleName()) == null) {
            Fragment authFragment = new AuthFragment();
            fragmentManager.beginTransaction().
                    replace(R.id.content_splash_screen, authFragment, AuthFragment.class.getSimpleName())
                    .commit();
        }

    }
}
