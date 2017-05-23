package com.ammase.caricari.ui.activity.akun;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ammase.caricari.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AkunMainActivity extends AppCompatActivity {

    @BindView(R.id.header_cover_image)
    ImageView imageHeader;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_akun_main);
        ButterKnife.bind(this);
/*        Drawable rightArrow = ResourcesCompat.getDrawable(getResources(), R.drawable.picture2, null);
        rightArrow.setAlpha(50);
        imageHeader.setImageDrawable(rightArrow);*/

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


    }
}
