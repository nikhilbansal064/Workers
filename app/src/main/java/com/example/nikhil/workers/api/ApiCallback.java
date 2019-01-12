package com.example.nikhil.workers.api;

public interface ApiCallback {

        public void onSuccess(Object response);
        public void onFailure(String failureMsg);

}
