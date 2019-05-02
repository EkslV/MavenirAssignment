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

    private static final String BOOK = "book",
            MOVIE = "movie",
            THEATRE_SHOW = "Theatre show";
    private static final int GREEN = 1;
    private static final int MAGENTA = 2;
    private static final int CYAN = 3;
    private static final int NO_COLOR = 0;

    private List<BaseArt> artList;

    public ArtAdapter() {
        artList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ItemHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.art_item, viewGroup, false), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        BaseArt currentArt = artList.get(position);

        itemHolder.artName.setText(currentArt.getTitle());
        itemHolder.artType.setText(currentArt.getType());

        if (currentArt.getImgUrl() != null && !currentArt.getImgUrl().isEmpty()) {
            Glide.with(itemHolder.itemView.getContext())
                    .load(currentArt.getImgUrl())
                    .apply(new RequestOptions().circleCrop())
                    .apply(new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(itemHolder.artIcon);
        } else {
            itemHolder.artIcon.setImageResource(0);
        }
    }

    @Override
    public int getItemViewType(int position) {
        BaseArt art = artList.get(position);
        switch (art.getType()) {
            case BOOK:
                return GREEN;
            case MOVIE:
                return MAGENTA;
            case THEATRE_SHOW:
                return CYAN;
        }
        return NO_COLOR;
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

        public ItemHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            switch (viewType) {
                case NO_COLOR:
                    itemView.setBackgroundColor(Color.WHITE);
                    break;
                case GREEN:
                    itemView.setBackgroundColor(Color.GREEN);
                    break;
                case MAGENTA:
                    itemView.setBackgroundColor(Color.MAGENTA);
                    break;
                case CYAN:
                    itemView.setBackgroundColor(Color.CYAN);
                    break;
            }

            artIcon = itemView.findViewById(R.id.artIcon);
            artType = itemView.findViewById(R.id.artType);
            artName = itemView.findViewById(R.id.artName);
        }
    }
}
