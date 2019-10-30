package com.example.preloved;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewPrelovedAdapter extends RecyclerView.Adapter<CardViewPrelovedAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Preloved> listPreloved;

    public CardViewPrelovedAdapter(Context context) {
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
    public CardViewPrelovedAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_preloved, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewPrelovedAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        Preloved p = getListPreloved().get(i);
        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(p.getName());
        cardViewViewHolder.tvRemarks.setText(p.getRemarks());

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListPreloved().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.btnOrder.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Order " + getListPreloved().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPreloved().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnOrder;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnOrder = itemView.findViewById(R.id.btn_set_order);
        }
    }
}
