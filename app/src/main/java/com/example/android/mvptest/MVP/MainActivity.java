package com.example.android.mvptest.MVP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.mvptest.Adapter.Adapter;
import com.example.android.mvptest.Model.ModelUsers;
import com.example.android.mvptest.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity  implements MainActivityContract.View{

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    MainActivityPresenter presenter;
    Adapter adapter;
    ArrayList<ModelUsers> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        presenter = new MainActivityPresenter();
        presenter.attachView(this);
        presenter.start();
        presenter.loadUsersData();

    }

    @Override
    public void setErrorUi(String error) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUi(ArrayList<ModelUsers> data) {
        progressBar.setVisibility(View.GONE);
        list.clear();
        list.addAll(data);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void initUi() {
        progressBar.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
