package com.dani2pix.recipr.api;


import com.dani2pix.recipr.ui.authentication.model.GuestSession;
import com.dani2pix.recipr.ui.authentication.model.Token;
import com.dani2pix.recipr.ui.authentication.model.Session;
import com.dani2pix.recipr.ui.authentication.model.ValidatedToken;
import com.dani2pix.recipr.ui.dashboard.model.DiscoverMedia;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Domnica on 1/28/2017.
 */

public interface ApiService {

    @GET(ApiConstants.CREATE_REQUEST_TOKEN)
    Observable<Token> requestToken(@Query(ApiConstants.QUERY_API_KEY) String apiKey);

    @GET(ApiConstants.VALIDATE_REQUEST_TOKEN)
    Observable<ValidatedToken> requestTokenValidation(@Query(ApiConstants.QUERY_API_KEY) String apiKey,
                                                      @Query("username") String username,
                                                      @Query("password") String password,
                                                      @Query(ApiConstants.QUERY_REQUEST_TOKEN) String requestToken);

    @GET(ApiConstants.CREATE_SESSION)
    Observable<Session> requestSession(@Query(ApiConstants.QUERY_API_KEY) String apiKey,
                                       @Query(ApiConstants.QUERY_REQUEST_TOKEN) String requestToken);

    @GET(ApiConstants.CREATE_GUEST_SESSION)
    Observable<GuestSession> requestGuestSession(@Query(ApiConstants.QUERY_API_KEY) String apiKey);

    @GET(ApiConstants.EXPLORE_MOVIES)
    Observable<DiscoverMedia> exploreMovies(@Query(ApiConstants.QUERY_API_KEY) String apiKey);

    @GET(ApiConstants.EXPLORE_TV_SHOWS)
    Observable<DiscoverMedia> exploreTvShows(@Query(ApiConstants.QUERY_API_KEY) String apiKey);

    @GET(ApiConstants.EXPLORE_PEOPLE)
    Observable<People> explorePopularPeople(@Query(ApiConstants.QUERY_API_KEY) String apiKey);
}
