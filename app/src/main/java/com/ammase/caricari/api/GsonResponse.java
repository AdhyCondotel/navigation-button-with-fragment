package com.ammase.caricari.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gd on 3/1/2017.
 */

public class GsonResponse {
    @SerializedName("success")
    private int success;

    public int getSuccess(){
        return success;
    }
}
