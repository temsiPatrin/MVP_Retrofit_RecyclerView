package com.example.android.mvptest.MVP;

import com.example.android.mvptest.Model.ModelMainActivity;
import com.example.android.mvptest.Model.ModelUsers;

import java.util.ArrayList;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    MainActivityContract.Model model;

    public MainActivityPresenter() {
        this.model = new ModelMainActivity(MainActivityPresenter.this);
    }

    @Override
    public void loadUsersData() {
        model.getUsersList();
    }

    @Override
    public void onSuccess(ArrayList<ModelUsers> body) {
        if (view != null) {
            view.updateUi(body);
        }
    }

    @Override
    public void onError(String error) {
        if (view != null) {
            view.setErrorUi(error);
        }
    }

    @Override
    public void start() {
        if (view != null) {
            view.initUi();
        }

    }

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
