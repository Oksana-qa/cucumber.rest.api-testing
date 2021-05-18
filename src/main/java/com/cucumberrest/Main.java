package com.cucumberrest;

import com.cucumberrest.api.RestApiService;
import com.cucumberrest.api.models.Location;
import com.cucumberrest.api.models.LocationResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    public static void main(String[] args){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApiService service = retrofit.create(RestApiService.class);

//        Call<GetResponse> request = service.getBin(
//                "$2b$10$AYVaJqCoWXJ84akVXK8lxOhdl8F/hf/aXc8P3tt0WZZtvDcBjwQTy",
//                "60807268a2213a0c14283498");
//        request.enqueue(new Callback<GetResponse>() {
//
//            @Override
//            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
//                GetResponse bin = response.body();
//                int i = 0;
//            }
//
//            @Override
//            public void onFailure(Call<GetResponse> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

//        Call<DeleteResponse> request = service.deleteBin(
//                "$2b$10$AYVaJqCoWXJ84akVXK8lxOhdl8F/hf/aXc8P3tt0WZZtvDcBjwQTy",
//                "60807268a2213a0c14283498");
//        request.enqueue(new Callback<DeleteResponse>() {
//            @Override
//            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
//                DeleteResponse bin = response.body();
//                int i = 0;
//            }
//
//            @Override
//            public void onFailure(Call<DeleteResponse> call, Throwable t) {
//
//            }
//        });


//        Location location = new Location("Haarlem", "Rippeerdapark 35");
//
//        Call<Response> request = service.createBin(
//                "$2b$10$AYVaJqCoWXJ84akVXK8lxOhdl8F/hf/aXc8P3tt0WZZtvDcBjwQTy",
//                location);
//        request.enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                Response bin = response.body();
//                int i = 0;
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });


        Location location = new Location("Kherson", "49 Gvardeiskoy Divizii");

        Call<LocationResponse> request = service.updateBin(
                "$2b$10$AYVaJqCoWXJ84akVXK8lxOhdl8F/hf/aXc8P3tt0WZZtvDcBjwQTy",
                "60807c61027da70c476e0bf1",
                location);

        request.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, retrofit2.Response<LocationResponse> response) {
                LocationResponse bin = response.body();
                int i = 0;
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
