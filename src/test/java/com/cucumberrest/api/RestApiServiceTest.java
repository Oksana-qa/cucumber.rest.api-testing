package com.cucumberrest.api;

import com.cucumberrest.api.models.Location;
import com.cucumberrest.api.models.LocationResponse;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class RestApiServiceTest {
    private static final String API_KEY = "$2b$10$AYVaJqCoWXJ84akVXK8lxOhdl8F/hf/aXc8P3tt0WZZtvDcBjwQTy";
    private static final int RESPONSE_CODE_OK = 200;
    private static final int RESPONSE_CODE_NOT_FOUND = 404;
    private static final int RESPONSE_CODE_WRONG_FORMAT = 422;

    private RestApiService service;

    @BeforeEach
    void initRestService(){
        service = new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApiService.class);
    }

    @Test
    void onGetNotFound() throws IOException{
        Response<LocationResponse> response = service.getBin(API_KEY, "60807268a2213a0c14283498").execute();
        Assert.assertEquals(RESPONSE_CODE_NOT_FOUND, response.code());
    }

    @Test
    void onGetWrongIdFormat() throws IOException{
        Response<LocationResponse> response = service.getBin(API_KEY, "60807268a2213a0c14").execute();
        Assert.assertEquals(RESPONSE_CODE_WRONG_FORMAT, response.code());
    }

    @Test
    void onGetSuccess() throws IOException{
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("location.json");
        String json = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        Location location = new Gson().fromJson(json, Location.class);


        Response<LocationResponse> response = service.getBin(API_KEY, "60807e66027da70c476e0d5a").execute();
        Assert.assertEquals(RESPONSE_CODE_OK, response.code());


        Location locationFromAPI = response.body().getLocation();
        Assert.assertEquals(location.getCity(), locationFromAPI.getCity());
        Assert.assertEquals(location.getAddress(), locationFromAPI.getAddress());
    }
}
