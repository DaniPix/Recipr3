package com.dani2pix.recipr.ui.presenter;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
