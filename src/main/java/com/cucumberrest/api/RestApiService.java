package com.cucumberrest.api;

import com.cucumberrest.api.models.DeleteResponse;
import com.cucumberrest.api.models.LocationResponse;
import com.cucumberrest.api.models.Location;
import retrofit2.Call;
import retrofit2.http.*;

public interface RestApiService {

    @Headers("Content-Type: application/json")
    @POST("b")
    Call<LocationResponse> createBin(@Header("X-Master-key") String apiKey, @Body Location location);

    @GET("b/{id}")
    Call<LocationResponse> getBin(@Header("X-Master-key") String apiKey, @Path("id") String binId);

    @Headers("Content-Type: application/json")
    @PUT("b/{id}")
    Call<LocationResponse> updateBin(@Header("X-Master-key") String apiKey, @Path("id") String binId, @Body Location location);

    @DELETE("b/{id}")
    Call<DeleteResponse> deleteBin(@Header("X-Master-key") String apiKey, @Path("id") String binId);
}