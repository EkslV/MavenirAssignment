package com.test.mavenirassignment.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.test.mavenirassignment.R;
import com.test.mavenirassignment.models.BaseArt;

import java.util.ArrayList;
import java.util.List;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ItemHolder> {

    public static final String BOOK = "book",
            MOVIE = "movie",
            THEATRE_SHOW = "Theatre show";

    private List<BaseArt> artList;

    public ArtAdapter() {
        artList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.art_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        BaseArt currentArt = artList.get(i);

        itemHolder.artName.setText(currentArt.getTitle());
        itemHolder.artType.setText(currentArt.getType());

        if (currentArt.getType().matches(BOOK)) {
            itemHolder.itemView.setBackgroundColor(Color.GREEN);
        } else if (currentArt.getType().matches(MOVIE)) {
            itemHolder.itemView.setBackgroundColor(Color.MAGENTA);
        } else if (currentArt.getType().matches(THEATRE_SHOW)) {
            itemHolder.itemView.setBackgroundColor(Color.CYAN);
        } else {
            itemHolder.itemView.setBackgroundColor(Color.WHITE);
        }

        if (currentArt.getImgUrl() != null && !currentArt.getImgUrl().isEmpty()) {
            Glide.with(itemHolder.itemView.getContext())
                    .load(currentArt.getImgUrl())
                    .apply(new RequestOptions().circleCrop())
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(itemHolder.artIcon);
        }
    }

    @Override
    public int getItemCount() {
        return artList.size();
    }

    public void setData(List<BaseArt> artItems) {
        artList = artItems;
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView artIcon;
        private TextView artType, artName;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            artIcon = itemView.findViewById(R.id.artIcon);
            artType = itemView.findViewById(R.id.artType);
            artName = itemView.findViewById(R.id.artName);
        }
    }
}
