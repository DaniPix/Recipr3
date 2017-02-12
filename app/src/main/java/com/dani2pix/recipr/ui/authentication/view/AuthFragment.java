package com.dani2pix.recipr.ui.authentication.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.ui.authentication.presenter.AuthPresenter;
import com.dani2pix.recipr.constants.Constants;
import com.dani2pix.recipr.ui.dashboard.view.DashActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domnica on 1/28/2017.
 */

public class AuthFragment extends Fragment implements AuthView, View.OnClickListener {

    @Inject
    AuthPresenter presenter;
    @Inject
    Context context;
    @Inject
    SharedPreferences prefs;

    @BindView(R.id.username)
    TextInputEditText username;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.login)
    Button login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
        presenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        ButterKnife.bind(this, view);
        login.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    @Override
    public void onClick(View v) {
        presenter.fetchToken();
    }

    @Override
    public void onTokenReceived(String token) {
        presenter.validateToken(String.valueOf(username.getText()), String.valueOf(password.getText()), token);
    }

    @Override
    public void onTokenValidated(String validatedToken) {
        presenter.fetchSession(validatedToken);
    }

    @Override
    public void onSessionReceived(String sessionId) {
        prefs.edit().putString(Constants.SESSION_ID, sessionId).apply();
        Toast.makeText(context, "Authentication successful.", Toast.LENGTH_SHORT).show();
        //TODO Change this
        Intent intent = new Intent(context, DashActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onGuessSessionReceived(String guestSessionId) {
        prefs.edit().putString(Constants.GUEST_SESSION_Id, guestSessionId).apply();
    }

    @Override
    public void onAuthenticationFailure() {
        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show();
    }
}

