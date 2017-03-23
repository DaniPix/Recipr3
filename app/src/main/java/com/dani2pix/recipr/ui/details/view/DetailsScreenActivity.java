package com.dani2pix.recipr.ui.details.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.dani2pix.recipr.R;

/**
 * Created by dandomnica on 11/03/17.
 */

public class DetailsScreenActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		ActivityCompat.postponeEnterTransition(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.container);
		String posterPath = getIntent().getStringExtra("POSTER_PATH");

		FragmentManager fragmentManager = getFragmentManager();
		Fragment detailsFragment = new DetailsScreenFragment();
		Bundle bundle = new Bundle();
		bundle.putString("POSTER_PATH", posterPath);

		detailsFragment.setArguments(bundle);
		fragmentManager.beginTransaction()
				.replace(R.id.container, detailsFragment, DetailsScreenFragment.TAG)
				.commit();
	}
}
