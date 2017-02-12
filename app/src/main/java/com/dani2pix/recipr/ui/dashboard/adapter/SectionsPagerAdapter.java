package com.dani2pix.recipr.ui.dashboard.adapter;

/**
 * Created by Domnica on 2/12/2017.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ui.dashboard.view.DashboardFragment;

import javax.inject.Inject;

/**
 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @Inject
    Context context;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new DashboardFragment().newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.explore);
            case 1:
                return context.getString(R.string.movies);
            case 2:
                return context.getString(R.string.shows);
            case 3:
                return context.getString(R.string.people);
            default:
                return null;
        }
    }
}
