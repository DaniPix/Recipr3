package com.dani2pix.recipr.ui.authentication.view;

import com.dani2pix.recipr.ui.view.View;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthView extends View {

    void onTokenReceived(String token);

    void onTokenValidated(String validatedToken);

    void onSessionReceived(String sessionId);

    void onGuessSessionReceived(String guestSessionId);

    void onAuthenticationFailure();
}
