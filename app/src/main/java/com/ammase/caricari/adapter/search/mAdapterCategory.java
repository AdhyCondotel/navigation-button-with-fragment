package com.ammase.caricari.adapter.search;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ammase.caricari.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gd on 7/19/2016.
 */
public class mAdapterCategory extends RecyclerView.Adapter<mAdapterCategory.ViewHolder> {
private ArrayList<String> listGambar;
private Activity activity;

    public mAdapterCategory(Activity activity, ArrayList<String> listGambar) {
        this.listGambar = listGambar;
        this.activity = activity;
    }


    @Override
    public int getItemCount() {
        return listGambar.size();
    }

    @Override
    public mAdapterCategory.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_category, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtCategory.setText(listGambar.get(position));

        AssetManager assetManager = activity.getAssets();
        InputStream is;
        try {
            is = assetManager.open(listGambar.get(position)+".png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.imgCategory.setImageBitmap(bitmap);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textViewCategory) TextView txtCategory;
        @BindView(R.id.imageViewCategory) ImageView imgCategory;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
