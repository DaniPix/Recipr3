package com.dani2pix.recipr.authentication.view;

import com.dani2pix.recipr.view.View;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthView extends View {

    void onAuthenticationSuccess();

    void onAuthenticationFailure();
}
