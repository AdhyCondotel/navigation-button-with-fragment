package com.ammase.caricari;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ammase.caricari.adapter.search.mAdapterCategory;
import com.ammase.caricari.navigation.BottomNavigationViewHelper;
import com.ammase.caricari.navigation.ViewPagerAdapter;
import com.ammase.caricari.ui.fragment.ActivityFragment;
import com.ammase.caricari.ui.fragment.FavoriteFragment;
import com.ammase.caricari.ui.fragment.HomeFragment;
import com.ammase.caricari.ui.fragment.NewsFragment;
import com.ammase.caricari.ui.fragment.SearchFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    private NewsFragment newsFragment;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private FavoriteFragment favoriteFragment;
    private ActivityFragment activityFragment;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_news:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.item_home:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.item_search:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.item_favorite:
                                viewPager.setCurrentItem(3);
                                break;
                            case R.id.item_activity:
                                viewPager.setCurrentItem(4);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        newsFragment = new NewsFragment();
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        favoriteFragment = new FavoriteFragment();
        activityFragment = new ActivityFragment();

        adapter.addFragment(newsFragment);
        adapter.addFragment(homeFragment);
        adapter.addFragment(searchFragment);
        adapter.addFragment(favoriteFragment);
        adapter.addFragment(activityFragment);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menus) {
        // Inflate this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menus);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_share) {
            Toast.makeText(getApplicationContext(), "Share Clicked", Toast.LENGTH_SHORT).show();   // Toast might be not display this is for any other action
            return true;
        } else if (id == R.id.action_akun){
            Toast.makeText(getApplicationContext(), "Akun Clicked", Toast.LENGTH_SHORT).show();   // Toast might be not display this is for any other action
            return true;

        } else if (id == R.id.action_help){
            Toast.makeText(getApplicationContext(), "Help Clicked", Toast.LENGTH_SHORT).show();   // Toast might be not display this is for any other action
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void hideViews() {
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

     //   FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton.getLayoutParams();
      //  int fabBottomMargin = lp.bottomMargin;
       // mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    public void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
       // mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

}
