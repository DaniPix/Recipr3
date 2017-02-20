package com.dani2pix.recipr.ui.dashboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ui.dashboard.model.Movie;
import com.dani2pix.recipr.ui.dashboard.model.People;
import com.dani2pix.recipr.ui.dashboard.model.TvShow;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by Domnica on 2/18/2017.
 */

public class DashboardAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Picasso picasso;
    private int layout;

    public DashboardAdapter(List<T> data, Context context) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.picasso = Picasso.with(context);
        this.layout = R.layout.dashboard_item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layout, parent, false);
        return new DashboardHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DashboardHolder) {
            DashboardHolder dashHolder = (DashboardHolder) holder;
            T item = data.get(position);
            setUpItem(item, dashHolder);
        }
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void setUpItem(T item, DashboardHolder holder) {
        if (item instanceof Movie) {
            Movie movie = (Movie) item;

            holder.title.setText(movie.getTitle());
            holder.overview.setText(movie.getOverview());
            holder.metaData.setText(movie.getReleaseDate() + ", " + movie.getVoteCount());
            picasso.load("https://image.tmdb.org/t/p/" + "w300" + movie.getPosterPath()).into(holder.poster);
        } else if (item instanceof TvShow) {
            TvShow show = (TvShow) item;

            holder.title.setText(show.getName());
            holder.overview.setText(show.getOverview());
            holder.metaData.setText(show.getFirstAirDate() + ", " + show.getVoteCount());
            picasso.load("https://image.tmdb.org/t/p/" + "w300" + show.getPosterPath()).into(holder.poster);
        } else {
            People people = (People) item;

            holder.title.setText(people.getName());
            holder.metaData.setText(String.valueOf(people.getPopularity()));
            picasso.load("https://image.tmdb.org/t/p/" + "w300" + people.getProfilePath()).into(holder.poster);
        }
    }
}
