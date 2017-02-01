package com.dani2pix.recipr.api;


import com.dani2pix.recipr.authentication.model.RequestToken;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface AuthApiService {
    @GET(AuthApiConstants.CREATE_REQUEST_TOKEN)
    Observable<RequestToken> requestToken(@Query(AuthApiConstants.QUERY_API_KEY) String apiKey);



}
