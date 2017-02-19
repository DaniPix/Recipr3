package com.dani2pix.recipr.ui.dashboard.adapter;

/**
 * Created by Domnica on 2/12/2017.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ui.dashboard.view.DashboardFragment;
import com.dani2pix.recipr.ui.dashboard.view.MoviesFragment;
import com.dani2pix.recipr.ui.dashboard.view.PeopleFragment;
import com.dani2pix.recipr.ui.dashboard.view.ShowsFragment;

import javax.inject.Inject;

/**
 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MoviesFragment();
            case 1:
                return new ShowsFragment();
            case 2:
                return new PeopleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.movies);
            case 1:
                return context.getString(R.string.shows);
            case 2:
                return context.getString(R.string.people);
            default:
                return null;
        }
    }
}
