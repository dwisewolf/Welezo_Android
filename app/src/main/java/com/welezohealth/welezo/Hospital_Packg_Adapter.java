package com.welezohealth.welezo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Hospital_Packg_Adapter extends RecyclerView.Adapter<Hospital_Packg_Adapter.HospViewHolder> {

    private List<ModelHosp_Package> modelHosp_packages;
    private RecyclerView hosp_rView;

    public Hospital_Packg_Adapter(List<ModelHosp_Package> modelHosp_packages, RecyclerView hosp_rView) {
        this.modelHosp_packages = modelHosp_packages;
        this.hosp_rView = hosp_rView;
    }

    @NonNull
    @Override
    public HospViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.hospital_package,
                parent,
                false
        );
        HospViewHolder viewHolder = new HospViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HospViewHolder holder, int position) {
        holder.set(modelHosp_packages.get(position));
    }

    @Override
    public int getItemCount() {
        return modelHosp_packages.size();
    }

    class HospViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalname, rateings;
        ImageView hosp_img;

        public HospViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalname = itemView.findViewById(R.id.hosppackage_head);
            rateings = itemView.findViewById(R.id.total_rateing);
            hosp_img=itemView.findViewById(R.id.package_image);

        }

        public void set(ModelHosp_Package modelHosp_package) {

            Picasso.get().load(modelHosp_package.getHospital_img()).into(hosp_img);

            hospitalname.setText(modelHosp_package.getHospital_name());

            rateings.setText(String.valueOf(modelHosp_package.getRateing()));
        }
    }
}
