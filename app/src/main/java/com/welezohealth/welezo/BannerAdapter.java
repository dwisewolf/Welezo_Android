package com.welezohealth.welezo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private List<BannerItems> bannerItems;
    private ViewPager2 viewPager2;

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.viewpager_content,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.setImage(bannerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return bannerItems.size();
    }

    public BannerAdapter(List<BannerItems> bannerItems, ViewPager2 viewPager2) {
        this.bannerItems = bannerItems;
        this.viewPager2 = viewPager2;
    }

    class  BannerViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;

        public BannerViewHolder(@NonNull View itemView ) {
            super(itemView);
            imageView=itemView.findViewById(R.id.viewpager_content);
        }
        void setImage(BannerItems bannerItems){
            Picasso.get().load(bannerItems.getImage()).into(imageView);
        }
    }
}

