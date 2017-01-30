package com.dani2pix.recipr.authentication.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

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
        presenter.beginAuthenticationProcess();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onAuthenticationSuccess() {
        Toast.makeText(getActivity(), "Success.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationFailure() {
        Toast.makeText(getActivity(), "Failure.", Toast.LENGTH_SHORT).show();
    }
}

