package com.dani2pix.recipr.authentication.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.dani2pix.recipr.authentication.presenter.AuthPresenter;

import javax.inject.Inject;

/**
 * Created by Domnica on 1/28/2017.
 */

public class AuthFragment extends Fragment implements AuthView {

    @Inject
    AuthPresenter presenter;
    @Inject
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
        presenter.attachView(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter.fetchToken();
        View view = inflater.inflate(R.layout.fragment_auth, container, false);


        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    @Override
    public void onTokenRequestSuccess(String token) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/authenticate/" + token));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        Toast.makeText(getActivity(), "Token request success.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTokenRequestFailure() {
        Toast.makeText(getActivity(), "Token request failure.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationSuccess() {
        Toast.makeText(getActivity(), "Authentication success.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationFailure() {
        Toast.makeText(getActivity(), "Authentication failure.", Toast.LENGTH_SHORT).show();
    }


}

