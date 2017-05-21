package com.ammase.caricari.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Pratik Butani
 */
public class RetroClient {

    /********
     * URLS
     *******/

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("http://android.karebosimobileapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static RequestInterface getApiService() {
        return getRetrofitInstance().create(RequestInterface.class);
    }

}
