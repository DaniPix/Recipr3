package com.dani2pix.recipr.authentication.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dani2pix.recipr.authentication.presenter.AuthPresenter;

/**
 * Created by Domnica on 1/28/2017.
 */

public class AuthFragment extends Fragment implements AuthView {

    private AuthPresenter authPresenter;
    protected EditText username;
    protected EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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

