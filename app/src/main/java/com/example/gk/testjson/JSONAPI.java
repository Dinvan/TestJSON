package com.example.gk.testjson;
import com.example.gk.testjson.model.Destination;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Dinesh on 2/22/2017.
 */

public interface JSONAPI {
    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Book
    */
    @GET("/getAllContent")
    public void getBooks(@Query("placeCode") String placeCode, Callback<Destination> response);
}
