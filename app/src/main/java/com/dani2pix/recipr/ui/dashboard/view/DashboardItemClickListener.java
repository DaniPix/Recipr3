package com.dani2pix.recipr.ui.dashboard.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import com.dani2pix.recipr.util.listener.OnItemClickListener;

/**
 * Created by dandomnica on 12/03/17.
 */

public class DashboardItemClickListener implements RecyclerView.OnItemTouchListener {

	private GestureDetector gestureDetector;
	private OnItemClickListener onItemClickListener;
	private RecyclerView recyclerView;


	public DashboardItemClickListener(Context context, RecyclerView recyclerView, OnItemClickListener listener) {
		this.onItemClickListener = listener;
		this.recyclerView = recyclerView;
		gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				return true;
			}
		});
	}

	@Override
	public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
		View children = rv.findChildViewUnder(e.getX(), e.getY());
		if (children != null && gestureDetector.onTouchEvent(e) && onItemClickListener != null) {
			onItemClickListener.onItemClick(children, recyclerView.getChildAdapterPosition(children));
		}

		return false;
	}

	@Override
	public void onTouchEvent(RecyclerView rv, MotionEvent e) {
		// not needed
	}

	@Override
	public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
		// not needed
	}
}
