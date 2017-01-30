package com.dani2pix.recipr.api;

/**
 * Created by Domnica on 1/30/2017.
 */

public interface NetworkService {

    void fetchRequestToken(AuthCallback callback);

    interface AuthCallback {
        void onSuccess();

        void onError();
    }
}
