package com.dani2pix.recipr.ui.details.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dani2pix.recipr.R;
import com.dani2pix.recipr.ReciprApplication;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dandomnica on 11/03/17.
 */

public class DetailsScreenFragment extends Fragment {

	public static final String TAG = DetailsScreenFragment.class.getName();

	@BindView(R.id.detailsScreenPoster)
	ImageView poster;
	@Inject
	Context context;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((ReciprApplication) getActivity().getApplication()).getComponent().inject(this);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.details_screen, container, false);
		ButterKnife.bind(this, view);
		Bundle bundle = getArguments();
		String posterPath = bundle.getString("POSTER_PATH");
		Picasso.with(context).load("https://image.tmdb.org/t/p/" + "w300" + posterPath).into(poster);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ActivityCompat.startPostponedEnterTransition(getActivity());
	}
}
