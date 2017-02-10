package com.dani2pix.recipr.api.http;

/**
 * Created by Domnica on 1/30/2017.
 */

public interface AuthService {

    void fetchToken(AuthCallback authCallback);

    void validateToken(AuthCallback authCallback, String username, String password, String token);

    void fetchSession(AuthCallback authCallback, String validatedToken);

    void fetchGuestSession(AuthCallback authCallback);

    abstract class AuthCallback {
        public void onTokenReceived(String token) {

        }

        public void onTokenValidated(String validatedToken) {

        }

        public void onSessionReceived(String session) {

        }

        public void onGuestSessionReceived(String guestSession) {

        }


        public void onError() {

        }
    }
}
