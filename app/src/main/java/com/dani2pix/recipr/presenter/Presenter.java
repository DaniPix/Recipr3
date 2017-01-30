package com.dani2pix.recipr.presenter;

import android.content.Context;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
