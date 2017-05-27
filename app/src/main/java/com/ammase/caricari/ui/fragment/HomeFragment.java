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

import com.ammase.caricari.MainActivity;
import com.ammase.caricari.R;
import com.ammase.caricari.adapter.home.mAdapterHome;
import com.ammase.caricari.api.RequestInterface;
import com.ammase.caricari.api.RetroClient;
import com.ammase.caricari.model.home.BeritaItem;
import com.ammase.caricari.model.home.ResultGetBerita;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<BeritaItem> listItem;
    private mAdapterHome mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup home = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, home);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new mAdapterHome (getActivity(), new ArrayList<BeritaItem>());
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
        return home;
    }
    private void requestDataPromo() {
        RequestInterface api = RetroClient.getClient().create(RequestInterface.class);
        Call<ResultGetBerita> call = api.getBerita();
        call.enqueue(new Callback<ResultGetBerita>() {
            @Override
            public void onResponse(Call<ResultGetBerita> call, Response<ResultGetBerita> response) {
                ResultGetBerita jsonResponse = response.body();
                try {
                    listItem = new ArrayList<BeritaItem>(jsonResponse.getBerita());
                    mAdapter.setListItem(listItem);
                    mAdapter.notifyDataSetChanged();


                }catch (Exception e) {
                    e.printStackTrace();


                }
                swipeRefreshLayout.setRefreshing(false);
                recyclerView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<ResultGetBerita> call, Throwable t) {
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
