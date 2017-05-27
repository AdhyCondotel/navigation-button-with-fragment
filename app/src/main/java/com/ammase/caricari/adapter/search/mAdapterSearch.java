package com.ammase.caricari.adapter.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ammase.caricari.R;
import com.ammase.caricari.model.home.BeritaItem;
import com.ammase.caricari.ui.activity.DetailMainActivity;
import com.ammase.caricari.ui.activity.akun.AkunMainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lincoln on 31/03/16.
 */

public class mAdapterSearch extends RecyclerView.Adapter<mAdapterSearch.MyViewHolder> {
    private ArrayList<BeritaItem> resultsList;
    private Context mContext;

    public void setListItem(ArrayList<BeritaItem> listItem) {
        this.resultsList = listItem;

    }
    public mAdapterSearch(Context context, ArrayList<BeritaItem> images) {
        this.mContext = context;
        this.resultsList = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_search, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txtNanaObject.setText(resultsList.get(position).getJudul());
        holder.txtLocation.setText("JL. Santapan Buaya No 15");
        holder.txtCategory.setText("Menjual");
        holder.txtHarga.setText("Rp. 175.000,-");
        Glide.with(mContext).load(resultsList.get(position).getUrlGambar())
                .thumbnail(0.2f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgObject);

    }

    @Override
    public int getItemCount() {
        return resultsList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewImgObject) ImageView imgObject;
        @BindView(R.id.textViewNamaObject) TextView txtNanaObject;
        @BindView(R.id.textViewLocation) TextView txtLocation;
        @BindView(R.id.textViewCategoryObjec) TextView txtCategory;
        @BindView(R.id.textViewHargaObjec) TextView txtHarga;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            Typeface fontbold = Typeface.createFromAsset(itemView.getContext().getAssets(), "ABeeZee-Regular.ttf");
            this.txtNanaObject.setTypeface(fontbold);
            this.txtNanaObject.setTypeface(fontbold);

        }
    }
}