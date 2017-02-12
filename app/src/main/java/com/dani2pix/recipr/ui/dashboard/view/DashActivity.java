package com.dani2pix.recipr.ui.dashboard.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ui.dashboard.adapter.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domnica on 2/10/2017.
 */

public class DashActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;

    @BindView(R.id.container)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
    }
}
