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

public class PackageLong_Adapter extends RecyclerView.Adapter<PackageLong_Adapter.PackageLong_ViewHolder> {

    private List<Model_Recent_Add> recent_adds;
    private RecyclerView recent_add_recyclerView;

    public PackageLong_Adapter(List<Model_Recent_Add> recent_adds, RecyclerView recent_add_recyclerView) {
        this.recent_adds = recent_adds;
        this.recent_add_recyclerView = recent_add_recyclerView;
    }

    @NonNull
    @Override
    public PackageLong_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v= LayoutInflater.from(parent.getContext()).inflate(
             R.layout.packagecart_long,
             parent,
             false
     );
     PackageLong_ViewHolder viewHolder =new PackageLong_ViewHolder(v);
     return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PackageLong_ViewHolder holder, int position) {
holder.set(recent_adds.get(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class  PackageLong_ViewHolder extends RecyclerView.ViewHolder{
        ImageView add_image,std_icon;
        TextView package_heading,total_rateings,price;
        Button increment,decrement,value;
        RatingBar ratings;

        public PackageLong_ViewHolder(@NonNull View itemView) {
            super(itemView);

            add_image=itemView.findViewById(R.id.package_image);
            std_icon=itemView.findViewById(R.id.std_img);

            package_heading=itemView.findViewById(R.id.package_head);
            total_rateings=itemView.findViewById(R.id.total_rateing);
            price=itemView.findViewById(R.id.price);

            increment=itemView.findViewById(R.id.button_increment);
            decrement=itemView.findViewById(R.id.button_decrement);
            value=itemView.findViewById(R.id.button_value);
            ratings=itemView.findViewById(R.id.ratingBar3);
            ratings.setMax(5);
        }

        void set(Model_Recent_Add model_recent_add){

            Picasso.get().load(model_recent_add.getpackage_image()).into(add_image);

            package_heading.setText(model_recent_add.getPackage_head());

            total_rateings.setText(model_recent_add.getTotal_reviews());

            price.setText(model_recent_add.getAmont());

            ratings.setRating(model_recent_add.getRateings());
        }
    }
}
