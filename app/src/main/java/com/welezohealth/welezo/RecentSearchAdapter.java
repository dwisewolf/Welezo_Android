package com.welezohealth.welezo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.RecentSearchViewHolder>{
    private List<Model_RecentSearch> searchItems;
    private  RecyclerView searchItemListButton;


    @NonNull
    @Override
    public RecentSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentSearchViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recently_searched_buttons,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecentSearchViewHolder holder, int position) {

holder.settext(searchItems.get(position));
    }

    @Override
    public int getItemCount() {
        return searchItems.size();
    }

    public RecentSearchAdapter(List<Model_RecentSearch> searchItems, RecyclerView searchItemListButton) {
        this.searchItems = searchItems;
        this.searchItemListButton = searchItemListButton;
    }


    class  RecentSearchViewHolder extends RecyclerView.ViewHolder {
        private Button searchCat;

        public RecentSearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchCat = itemView.findViewById(R.id.recent_search_button);
        }

        void settext(Model_RecentSearch model_recentSearch){
            searchCat.setText(model_recentSearch.getSearchkeys());
        }

    }
}
