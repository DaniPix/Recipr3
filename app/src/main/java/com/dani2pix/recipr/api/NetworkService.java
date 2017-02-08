package com.dani2pix.recipr.api;

/**
 * Created by Domnica on 1/30/2017.
 */

public interface NetworkService {

    void fetchRequestToken(AuthCallback authCallback, AuthCallback.TokenCallback tokenCallback);

    void fetchSession(AuthCallback callback, String requestToken);

    interface AuthCallback {
        void onSuccess();

        void onError();

        interface TokenCallback {
            void onTokenRetrieved(String token);
        }
    }
}
