package com.ammase.caricari.adapter.favorite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ammase.caricari.R;
import com.ammase.caricari.model.favorite.GaleriItem;
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

public class mAdapterFavorite extends RecyclerView.Adapter<mAdapterFavorite.MyViewHolder> {
    private ArrayList<GaleriItem> resultsList;
    private Context mContext;

    public void setListItem(ArrayList<GaleriItem> listItem) {
        this.resultsList = listItem;

    }
    public mAdapterFavorite(Context context, ArrayList<GaleriItem> images) {
        this.mContext = context;
        this.resultsList = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_favorite, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txtNamaUser.setText(resultsList.get(position).getNamaGaleri());

     //   BeritaItem image = resultsList.get(position);
        Glide.with(mContext).load(resultsList.get(position).getUrlGambar())
                .thumbnail(0.1f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgObject);

/*        holder.imgObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mContext, DetailMainActivity.class);
                    detail.putExtra("item_namaUser", "nama");
                v.getContext().startActivity(detail);
            }
        });

        holder.ibtDeleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mContext, AkunMainActivity.class);
                    detail.putExtra("item_namaUser", "nama");
                v.getContext().startActivity(detail);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return resultsList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewImgObject) ImageView imgObject;
        @BindView(R.id.textViewNama) TextView txtNamaUser;
        @BindView(R.id.imageButton)
        ImageButton ibtDeleted;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            Typeface fontbold = Typeface.createFromAsset(itemView.getContext().getAssets(), "ABeeZee-Regular.ttf");
            this.txtNamaUser.setTypeface(fontbold);
            this.txtNamaUser.setTypeface(fontbold);

        }
    }
}