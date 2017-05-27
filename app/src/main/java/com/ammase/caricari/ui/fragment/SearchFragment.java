package com.ammase.caricari.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ammase.caricari.R;
import com.ammase.caricari.adapter.search.mAdapterCategory;
import com.ammase.caricari.ui.activity.search.SearchMainActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends Fragment {

    private mAdapterCategory adapter_icon;
    private ArrayList<String> listGambar;

    @BindView(R.id.recyclerViewCategory) RecyclerView recyclerView;
    @BindView(R.id.LinearLayoutSearch)
    LinearLayout tblSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup search = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, search);

/*

        LinearLayoutManager layoutManagerRoom
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManagerRoom);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter_icon = new mAdapterCategory (getActivity(), listGambar);
        recyclerView.setAdapter(adapter_icon);*/

        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
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
    @OnClick(R.id.LinearLayoutSearch)
    public void tblSearch() {
        startActivity(new Intent(getContext(), SearchMainActivity.class));
        // TODO submit data to server...
    }


}
