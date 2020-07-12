package com.example.android.mvptest.Repository;

import com.example.android.mvptest.Model.ModelUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitNetworkApi {

    @GET("users/")
    Call<ArrayList<ModelUsers>> getUserList();
}
