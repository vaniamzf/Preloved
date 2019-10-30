package com.example.preloved;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPrelovedAdapter extends RecyclerView.Adapter<ListPrelovedAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Preloved> listPreloved;

    public ListPrelovedAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_preloved, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListPreloved().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListPreloved().get(position).getRemarks());
        Glide.with(context)
                .load(getListPreloved().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPreloved().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
