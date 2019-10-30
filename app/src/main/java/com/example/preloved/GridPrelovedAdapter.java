package com.example.preloved;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridPrelovedAdapter extends RecyclerView.Adapter<GridPrelovedAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Preloved> listPreloved;

    public GridPrelovedAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Preloved> getListPreloved() {
        return listPreloved;
    }

    public void setListPreloved(ArrayList<Preloved> listPreloved) {
        this.listPreloved = listPreloved;
    }


    @NonNull
    @Override
    public GridPrelovedAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_preloved, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridPrelovedAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListPreloved().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPreloved().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
