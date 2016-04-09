/**
 * Copyright 2016, Sinziana Gafitanu
 * Licensed under MIT (https://github.com/sinzianag/Crashly/blob/master/LICENSE)
 */

package com.sinzianag.android.crashly;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

	public MainActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View mainFragmentView = inflater.inflate(R.layout.fragment_main, container, false);
		Button navigateButton = (Button) mainFragmentView.findViewById(R.id.navigateButton);
		navigateButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goToFragment(new NavigateWithoutCrashFragment());
			}
		});

		Button exceptionButton = (Button) mainFragmentView.findViewById(R.id.exeption);
		exceptionButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				goToFragment(new ExceptionFragment());
			}
		});

		Button memoryButton = (Button) mainFragmentView.findViewById(R.id.memory);
		memoryButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				goToFragment(new OutOfMemoryFragment());
			}
		});

		Button threadButton = (Button) mainFragmentView.findViewById(R.id.thread);
		threadButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				goToFragment(new ThreadBlockingFragment());
			}
		});
		return mainFragmentView;

		// https://gist.github.com/dpryden/b2bb29ee2d146901b4ae
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	private void goToFragment(Fragment newFragment) {
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, newFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}
