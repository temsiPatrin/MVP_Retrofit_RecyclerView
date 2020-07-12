package com.example.android.mvptest.Model;

import android.util.Log;

import com.example.android.mvptest.MVP.MainActivityContract;
import com.example.android.mvptest.Retrofit.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMainActivity implements MainActivityContract.Model {

    MainActivityContract.Presenter presenter;

    public ModelMainActivity(MainActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getUsersList() {
        ApiService.getApiService().getUserList()
                .enqueue(new Callback<ArrayList<ModelUsers>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ModelUsers>> call, Response<ArrayList<ModelUsers>> response) {
                        if (response.isSuccessful()) {
                            presenter.onSuccess(response.body());
                        }
                        else {
                            assert response.errorBody() != null;
                            presenter.onError(response.errorBody().toString());
                            Log.i("mylog", "1 _" + response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ModelUsers>> call, Throwable t) {
                        presenter.onError(t.getMessage());
                        Log.i("mylog", "2 _" + t.getMessage());
                    }
                });
    }
}
