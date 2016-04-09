/**
 * Copyright 2016, Sinziana Gafitanu
 * Licensed under MIT (https://github.com/sinzianag/Crashly/blob/master/LICENSE)
 */

package com.sinzianag.android.crashly;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThreadBlockingFragment extends Fragment {

	public ThreadBlockingFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().getActionBar().setTitle(R.string.thread_blocking_name);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_thread_blocking, container, false);
	}

}
