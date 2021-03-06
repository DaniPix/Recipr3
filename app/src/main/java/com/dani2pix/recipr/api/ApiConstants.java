package com.dani2pix.recipr.api;

/**
 * Created by Domnica on 1/28/2017.
 */

public final class ApiConstants {
    // API key
    public static final String API_KEY = "ab704156f81d2af1445dc076bb9c869f";

    // API endpoint
    public static final String BASE_ENDPOINT = "https://api.themoviedb.org/3/";

    //Authentication queries constants
    public static final String QUERY_API_KEY = "api_key";
    public static final String QUERY_REQUEST_TOKEN = "request_token";

    //Authentication constants
    public static final String CREATE_REQUEST_TOKEN = "authentication/token/new";
    public static final String VALIDATE_REQUEST_TOKEN = "authentication/token/validate_with_login";
    public static final String CREATE_SESSION = "authentication/session/new";
    public static final String CREATE_GUEST_SESSION = "authentication/guest_session/new";

    //Dashboard constants
    public static final String EXPLORE_MOVIES = "discover/movie";
    public static final String EXPLORE_TV_SHOWS = "discover/tv";
    public static final String EXPLORE_PEOPLE = "person/popular";

    private ApiConstants() {
        // avoid instantiation
    }
}
