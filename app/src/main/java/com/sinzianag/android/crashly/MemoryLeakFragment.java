/**
 * Copyright 2016, Sinziana Gafitanu
 * Licensed under MIT (https://github.com/sinzianag/Crashly/blob/master/LICENSE)
 */

package com.sinzianag.android.crashly;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sgafitan on 4/2/16.
 */
public class MemoryLeakFragment extends Fragment {
	public MemoryLeakFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().getActionBar().setTitle(R.string.memory_leak);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_thread_blocking, container, false);
	}
}
