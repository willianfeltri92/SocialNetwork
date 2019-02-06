package com.example.socialnetwork.socialnetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers({"X-API-Key: 82333f10"})
    @GET("/mobiletest.json")
    Call<List<User>> getUsers();

}
