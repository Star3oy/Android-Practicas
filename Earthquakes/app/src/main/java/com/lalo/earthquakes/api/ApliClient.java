package com.lalo.earthquakes.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

public class ApliClient {

    public interface Service {
        @GET("all_hour.geojson")
        Call<EarthquakeJSONResponse> getEarthquakes();
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private Service service;
    private static  final ApliClient apiClient = new ApliClient();

    public static ApliClient getInstance() {
        return apiClient;
    }

    private ApliClient(){}

    public Service getService(){
        if(service == null){
            service = retrofit.create(Service.class);
        }
        return service;
    }

}
