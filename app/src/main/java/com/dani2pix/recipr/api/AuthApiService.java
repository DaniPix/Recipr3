package com.dani2pix.recipr.api;


import com.dani2pix.recipr.authentication.model.RequestTokenModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthApiService {
    @GET(AuthApiConstants.CREATE_REQUEST_TOKEN)
    Observable<RequestTokenModel> requestToken();
}
