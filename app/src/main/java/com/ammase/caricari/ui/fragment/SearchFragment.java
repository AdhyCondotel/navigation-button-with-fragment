package com.ammase.caricari.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ammase.caricari.R;
import com.ammase.caricari.adapter.search.mAdapterCategory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends Fragment {

    private mAdapterCategory adapter_icon;
    private ArrayList<String> listGambar;

    @BindView(R.id.recyclerViewCategory) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup search = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, search);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadIco();
        adapter_icon = new mAdapterCategory (getActivity(),listGambar);
        recyclerView.setAdapter(adapter_icon);

        return search;
    }

    private void loadIco() {
            listGambar= new ArrayList<String>();
            listGambar.add("Bakery");
            listGambar.add("Bolu");
            listGambar.add("Brownis");
            listGambar.add("Burger");
            listGambar.add("Cupcake");
            listGambar.add("Donut");
            listGambar.add("Kebab");
            listGambar.add("Krepes");
            listGambar.add("Pancake");
            listGambar.add("Puding");
    }

}
