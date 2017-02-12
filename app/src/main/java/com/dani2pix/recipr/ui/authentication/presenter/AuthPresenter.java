package com.dani2pix.recipr.ui.authentication.presenter;

import com.dani2pix.recipr.ui.authentication.view.AuthView;
import com.dani2pix.recipr.ui.presenter.Presenter;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthPresenter extends Presenter<AuthView> {
    void fetchToken();

    void validateToken(String username, String password, String token);

    void fetchSession(String validatedToken);

    void fetchGuestSession();
}
