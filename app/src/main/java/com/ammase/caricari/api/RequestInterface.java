package com.ammase.caricari.api;

import com.ammase.caricari.model.favorite.ResultGetGaleri;
import com.ammase.caricari.model.home.ResultGetBerita;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gd on 12/6/2016.
 */
public interface RequestInterface {


    //get data amonthly special
    @GET("karebosicondotel-api/data-berita/berita-menu.php")
    Call<ResultGetBerita> getBerita();

    //get data all produk
    @GET("karebosicondotel-api/data-galeri/galeri-menu.php")
    Call<ResultGetGaleri> getGaleri();

}
