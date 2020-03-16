package com.welezohealth.welezo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Recent_Add_Package_Adapter  extends RecyclerView.Adapter<Recent_Add_Package_Adapter.Recent_add_packageViewHolder>{
    private List<Model_Recent_Add> recent_adds;
    private RecyclerView recent_add_recyclerView;
    private  OnItemClickListner itemClickListner;

    public Recent_Add_Package_Adapter(List<Model_Recent_Add> recent_adds, RecyclerView recent_add_recyclerView) {
        this.recent_adds = recent_adds;
        this.recent_add_recyclerView = recent_add_recyclerView;
    }

    @NonNull
    @Override
    public Recent_add_packageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.package_card,
                parent,
                false
        );

        Recent_add_packageViewHolder viewHolder = new Recent_add_packageViewHolder(v,itemClickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recent_add_packageViewHolder holder, int position) {
holder.set(recent_adds.get(position));
    }

    @Override
    public int getItemCount() {
        return recent_adds.size();
    }

    class  Recent_add_packageViewHolder extends  RecyclerView.ViewHolder{
        ImageView add_image,wishlist_icon,share_icon;
        TextView package_heading,total_rateings,price;
        Button standard;
        RatingBar ratings;



        public Recent_add_packageViewHolder(View itemView, OnItemClickListner itemClickListner) {
            super(itemView);
            add_image=itemView.findViewById(R.id.add_image);

            share_icon=itemView.findViewById(R.id.share_icon);
            package_heading=itemView.findViewById(R.id.package_heading);
            total_rateings=itemView.findViewById(R.id.total_rateings);
            price=itemView.findViewById(R.id.price);
            standard=itemView.findViewById(R.id.standard);
            ratings=itemView.findViewById(R.id.ratings);
            ratings.setMax(5);

        }
        public void set(Model_Recent_Add model_recent_add){
            try {
                package_heading.setText(model_recent_add.getPackage_head());
                total_rateings.setText(model_recent_add.getTotal_reviews());
                price.setText(model_recent_add.getAmont());
                Picasso.get().load(model_recent_add.getpackage_image()).into(add_image);
                standard.setText(model_recent_add.getStandard());
                ratings.setRating(model_recent_add.getRateings());

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }

    }

    private class OnItemClickListner {
    }
}
