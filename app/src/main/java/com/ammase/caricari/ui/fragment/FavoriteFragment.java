package com.ammase.caricari.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ammase.caricari.R;
import com.ammase.caricari.adapter.favorite.mAdapterFavorite;
import com.ammase.caricari.api.RequestInterface;
import com.ammase.caricari.api.RetroClient;
import com.ammase.caricari.model.favorite.GaleriItem;
import com.ammase.caricari.model.favorite.ResultGetGaleri;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<GaleriItem> listItem;
    private mAdapterFavorite mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup favorite = (ViewGroup) inflater.inflate(R.layout.fragment_favorite, container, false);

        ButterKnife.bind(this, favorite);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new mAdapterFavorite (getActivity(), new ArrayList<GaleriItem>());
        recyclerView.setAdapter(mAdapter);

        requestDataPromo();
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        requestDataPromo();
                                    }
                                }
        );
        return favorite;
    }

    private void requestDataPromo() {
        RequestInterface api = RetroClient.getApiService();
        Call<ResultGetGaleri> call = api.getGaleri();
        call.enqueue(new Callback<ResultGetGaleri>() {
            @Override
            public void onResponse(Call<ResultGetGaleri> call, Response<ResultGetGaleri> response) {
                ResultGetGaleri jsonResponse = response.body();
                try {
                    listItem = new ArrayList<>(jsonResponse.getGaleri());
                    mAdapter.setListItem(listItem);
                    mAdapter.notifyDataSetChanged();


                }catch (Exception e) {
                    e.printStackTrace();


                }
                swipeRefreshLayout.setRefreshing(false);
                recyclerView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<ResultGetGaleri> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                //Snackbar.make(getView(), "Koneksi internet lemah...", Snackbar.LENGTH_LONG).show();

                recyclerView.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void onRefresh() {
        requestDataPromo();
    }
}
