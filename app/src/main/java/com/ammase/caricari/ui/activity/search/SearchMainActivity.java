package com.ammase.caricari.ui.activity.search;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.ammase.caricari.R;
import com.ammase.caricari.adapter.search.mAdapterSearch;
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

public class SearchMainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<BeritaItem> listItem;
    private mAdapterSearch mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new mAdapterSearch (this, new ArrayList<BeritaItem>());
        recyclerView.setAdapter(mAdapter);
        requestDataPromo();
    }

    private void requestDataPromo() {
        RequestInterface api = RetroClient.getClient().create(RequestInterface.class);
        Call<ResultGetBerita> call = api.getBerita();
        call.enqueue(new Callback<ResultGetBerita>() {
            @Override
            public void onResponse(Call<ResultGetBerita> call, Response<ResultGetBerita> response) {
                ResultGetBerita jsonResponse = response.body();
                if (jsonResponse.getSuccess() == 1){
                    listItem = new ArrayList<>(jsonResponse.getBerita());
                    mAdapter.setListItem(listItem);
                    mAdapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplication(), "Server tidak merespon....", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResultGetBerita> call, Throwable t) {
//                swipeRefreshLayout.setRefreshing(false);
                //Snackbar.make(getView(), "Koneksi internet lemah...", Snackbar.LENGTH_LONG).show();

                recyclerView.setVisibility(View.GONE);

            }
        });
    }

}
