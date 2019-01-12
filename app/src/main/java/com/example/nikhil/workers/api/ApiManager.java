package com.example.nikhil.workers.api;

import com.example.nikhil.workers.data_model.WorkerListData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private static ApiService apiService = ApiUtils.getApiService();

    public static void getWorkersList(final ApiCallback callback){
        Call<WorkerListData> call = apiService.getWorkers(ApiUtils.AUTH_KEY);

        call.enqueue(new Callback<WorkerListData>() {
            @Override
            public void onResponse(Call<WorkerListData> call, Response<WorkerListData> response) {
                WorkerListData workerListData = (WorkerListData) response.body();
                callback.onSuccess(workerListData);
            }

            @Override
            public void onFailure(Call<WorkerListData> call, Throwable t) {
                callback.onSuccess("ERROR");
            }

        });
    }

}
