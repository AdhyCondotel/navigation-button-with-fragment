package com.ammase.caricari.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ammase.caricari.MainActivity;
import com.ammase.caricari.R;
import com.ammase.caricari.model.home.BeritaItem;
import com.ammase.caricari.ui.activity.DetailMainActivity;
import com.ammase.caricari.ui.activity.akun.AkunMainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Lincoln on 31/03/16.
 */

public class mAdapterHome extends RecyclerView.Adapter<mAdapterHome.MyViewHolder> {
    private ArrayList<BeritaItem> resultsList;
    private Context mContext;

    public void setListItem(ArrayList<BeritaItem> listItem) {
        this.resultsList = listItem;

    }
    public mAdapterHome(Context context, ArrayList<BeritaItem> images) {
        this.mContext = context;
        this.resultsList = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_home, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtNamaUser.setText(resultsList.get(position).getJudul());
        holder.txtTglUpdate.setText("Update :" + resultsList.get(position).getTglPosting());
        holder.txtNanaObject.setText(resultsList.get(position).getJudul());
        holder.txtLocation.setText("JL. Santapan Buaya No 15");
        holder.txtLike.setText("Like : 25");
        holder.txtVisit.setText("Visit : 100");
        Glide.with(mContext).load(resultsList.get(position).getUrlGambar())
                .thumbnail(0.2f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgObject);

     //   BeritaItem image = resultsList.get(position);
        Glide.with(mContext).load(resultsList.get(position).getUrlGambar())
                .thumbnail(0.1f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgUser);

        holder.imgObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mContext, DetailMainActivity.class);
                    detail.putExtra("item_namaUser", "nama");
                v.getContext().startActivity(detail);
            }
        });

        holder.imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(mContext, AkunMainActivity.class);
                    detail.putExtra("item_namaUser", "nama");
                v.getContext().startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsList.size();

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewImgUser) ImageView imgUser;
        @BindView(R.id.imageViewImgObject) ImageView imgObject;
        @BindView(R.id.textViewNamaUser) TextView txtNamaUser;
        @BindView(R.id.textViewTglUpdate) TextView txtTglUpdate;
        @BindView(R.id.textViewNamaObject) TextView txtNanaObject;
        @BindView(R.id.textViewLocation) TextView txtLocation;
        @BindView(R.id.textViewLike) TextView txtLike;
        @BindView(R.id.textViewVisit) TextView txtVisit;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            Typeface fontbold = Typeface.createFromAsset(itemView.getContext().getAssets(), "ABeeZee-Regular.ttf");
            this.txtNamaUser.setTypeface(fontbold);
            this.txtNanaObject.setTypeface(fontbold);

        }
    }
}