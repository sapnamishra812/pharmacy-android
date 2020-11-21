package com.example.login.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.listener.LocationListener;
import com.example.login.model.Location;

public class LocationViewHolder extends RecyclerView.ViewHolder {

    private TextView tvLocationName;
    private LinearLayout llLocation;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        tvLocationName = itemView.findViewById(R.id.tv_location_name);
        llLocation = itemView.findViewById(R.id.ll_location);
    }

    public void bind(final Location location,final LocationListener locationListener){
        tvLocationName.setText(location.getName());
        llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationListener.onLocationSelected(location);
            }
        });
    }
}
