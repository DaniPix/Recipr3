package com.dani2pix.recipr.ui.splashscreen;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.constants.Constants;
import com.dani2pix.recipr.ui.authentication.view.AuthActivity;
import com.dani2pix.recipr.ui.dashboard.view.DashActivity;

import javax.inject.Inject;

public class SplashScreen extends AppCompatActivity {

    @Inject
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ((ReciprApplication) getApplication()).getComponent().inject(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("".equals(prefs.getString(Constants.SESSION_ID, ""))) {
                    startAuthActivity();
                } else {
                    startDashActivity();
                }
            }
        }, 1500);

    }

    private void startAuthActivity() {
        Intent intent = new Intent(this, AuthActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void startDashActivity() {
        Intent intent = new Intent(this, DashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
