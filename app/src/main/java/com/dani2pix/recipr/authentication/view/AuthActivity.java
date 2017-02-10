package com.dani2pix.recipr.authentication.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dani2pix.recipr.R;

/**
 * Created by Domnica on 2/8/2017.
 */

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        startAuthFragment();
    }


    private void startAuthFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new AuthFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.auth_container, fragment, AuthFragment.class.getName())
                .commit();

    }
}
