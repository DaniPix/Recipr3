package com.dani2pix.recipr.authentication.presenter;

import com.dani2pix.recipr.authentication.view.AuthView;
import com.dani2pix.recipr.presenter.Presenter;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthPresenter extends Presenter<AuthView> {
    void beingAuthenticationProcess();
}
