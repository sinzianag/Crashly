/**
 * Copyright 2016, Sinziana Gafitanu
 * Licensed under MIT (https://github.com/sinzianag/Crashly/blob/master/LICENSE)
 */

package com.sinzianag.android.crashly;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.sinzianag.android.crashly.utils.LogTag;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (findViewById(R.id.fragment_container) != null) {

			if (savedInstanceState != null) {
				return;
			}

			MainActivityFragment firstFragment = new MainActivityFragment();
			firstFragment.setArguments(getIntent().getExtras());
			getFragmentManager().beginTransaction()
					.add(R.id.fragment_container, firstFragment).commit();
		}

		handleBackStack();
		logOrientation(getResources().getConfiguration().orientation);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				FragmentManager fm = getFragmentManager();
				if (fm.getBackStackEntryCount() > 0) {
					fm.popBackStack();
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		logOrientation(newConfig.orientation);
	}

	/**
	 * Log Orientation to get an ideea of the state of the application when it crashes :D
	 * @param orientation
	 */
	private void logOrientation(int orientation) {
		if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Log.i(LogTag.APP_STATE,"Orientation is landscape");
		} else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
			Log.i(LogTag.APP_STATE,"Orientation is portrait");
		} else if (orientation == Configuration.ORIENTATION_UNDEFINED) {
			Log.i(LogTag.APP_STATE,"Orientation is undefined");
		}
	}

	private void handleBackStack() {
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
			@Override
			public void onBackStackChanged() {

				if (getFragmentManager().getBackStackEntryCount() > 0) {
					getActionBar().setDisplayHomeAsUpEnabled(true);
				} else {
					getActionBar().setDisplayHomeAsUpEnabled(false);
					getActionBar().setTitle(R.string.app_name);
				}
			}

		});
	}
}
