package com.dani2pix.recipr.ui.dashboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dani2pix.recipr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domnica on 2/18/2017.
 */

public class DashboardHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.poster)
    ImageView poster;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.genres)
    TextView genres;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.metaData)
    TextView metaData;

    public DashboardHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
