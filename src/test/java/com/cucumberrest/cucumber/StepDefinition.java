package com.cucumberrest.cucumber;

import com.cucumberrest.api.RestApiService;
import com.cucumberrest.api.models.Location;
import com.cucumberrest.api.models.LocationResponse;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class StepDefinition {
    private RestApiService service;

    private String apiKey;
    private Response<LocationResponse> response;

    @Given("I have REST API")
    public void createRestAPIService() {
        service = new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApiService.class);
    }

    @Given("I am authorized with {string}")
    public void addToken(String authData) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(authData);
        apiKey = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining(""));
    }

    @When("request record by {string}")
    public void getDataByID(String data) throws IOException {
        response = service.getBin(apiKey, data).execute();
    }

    @Then("response status is {int}")
    public void checkResponseStatus(int arg){
        Assert.assertEquals(arg, response.code());
    }

    @Then("I got a data from the REST API which is looks like {string}")
    public void checkResponseData(String res){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(res);
        String json = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining(""));
        Location location = new Gson().fromJson(json, Location.class);

        Location locationFromAPI = response.body().getLocation();
        Assert.assertEquals(location.getCity(), locationFromAPI.getCity());
        Assert.assertEquals(location.getAddress(), locationFromAPI.getAddress());
    }
}
