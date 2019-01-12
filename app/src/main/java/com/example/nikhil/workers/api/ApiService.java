package com.example.nikhil.workers.api;

import com.example.nikhil.workers.data_model.WorkerListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @Headers({
            "Content-Type: application/json",
            "X-Requested-With: XMLHttpRequest"
    })
    @GET("/api/sites/10010001/workers")
    Call<WorkerListData> getWorkers(@Header("Authorization") String authKey);
}
