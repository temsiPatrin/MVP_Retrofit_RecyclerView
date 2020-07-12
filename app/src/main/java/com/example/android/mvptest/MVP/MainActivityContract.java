package com.example.android.mvptest.MVP;

import com.example.android.mvptest.Model.ModelUsers;

import java.util.ArrayList;

public interface MainActivityContract {
    interface View{
        void setErrorUi(String error);

        void updateUi(ArrayList<ModelUsers> data);

        void initUi();
    }

    interface Presenter{
        void loadUsersData();

        void onSuccess(ArrayList<ModelUsers> body);

        void onError(String error);

        void start();

        void attachView(MainActivityContract.View view);
        void detachView();
    }

    interface Model{
        void getUsersList();
    }
}
