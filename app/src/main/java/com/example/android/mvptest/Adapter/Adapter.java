package com.example.android.mvptest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mvptest.Model.ModelUsers;
import com.example.android.mvptest.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelUsers> list;

    public Adapter(Context context, ArrayList<ModelUsers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_users, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelUsers user = list.get(position);

        holder.user_id.setText(user.getUserId());
        holder.user_name.setText(user.getUserName());
        holder.name.setText(user.getName());
        holder.user_email.setText(user.getUserEmail());
        holder.website.setText(user.getWebsite());

    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_id)
        TextView user_id;
        @BindView(R.id.user_name)
        TextView user_name;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.user_email)
        TextView user_email;
        @BindView(R.id.website)
        TextView website;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
