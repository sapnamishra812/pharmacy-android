package com.example.login.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.model.Store;

public class StoreViewHolder extends RecyclerView.ViewHolder {

    private TextView tvLocationName;


    public StoreViewHolder(@NonNull View itemView) {
        super(itemView);
        tvLocationName = itemView.findViewById(R.id.tv_store_name);
    }

    public void bind(final Store location){
        tvLocationName.setText(location.getName());

    }
}
