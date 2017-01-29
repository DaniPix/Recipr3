package com.dani2pix.recipr.splashscreen;


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

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SplashScreen extends AppCompatActivity {


    @Inject
    SharedPreferences prefs;
    @Inject
    Context context;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ((ReciprApplication)getApplication()).getComponent().inject(this);

        if(retrofit != null){
            Toast.makeText(context, "YEP", Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
