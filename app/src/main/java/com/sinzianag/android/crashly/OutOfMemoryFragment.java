/**
 * Copyright 2016, Sinziana Gafitanu
 * Licensed under MIT (https://github.com/sinzianag/Crashly/blob/master/LICENSE)
 */

package com.sinzianag.android.crashly;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class OutOfMemoryFragment extends Fragment {

	private View _outOfMemoryView = null;

	public OutOfMemoryFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().getActionBar().setTitle(R.string.out_of_memory_name);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		_outOfMemoryView =  inflater.inflate(R.layout.fragment_out_of_memory, container, false);


		Button drawableOOM = (Button) _outOfMemoryView.findViewById(R.id.drawableOOM);
		drawableOOM.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ImageView imageView = (ImageView) _outOfMemoryView.findViewById(R.id.imageView);
				imageView.setImageResource(R.drawable.earth);
			}
		});

		Button largeFileOOM = (Button) _outOfMemoryView.findViewById(R.id.largeFile);
		largeFileOOM.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/* Set<String> indexes = new HashSet<String)();

				FileInputStream is = new FileInputStream(indexPath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));

				String readLine;

				while ( (readLine = reader.readLine()) != null) {
					indexes.add(extractHeadWord(readLine));
				}

				private String extractHeadWord(String string) {
					String[] splitted = string.split("\\t");
					return splitted[0];
				} */
			}
		});

		return _outOfMemoryView;
	}
}
