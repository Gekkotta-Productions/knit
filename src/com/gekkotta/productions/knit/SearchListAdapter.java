package com.gekkotta.productions.knit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SearchListAdapter extends BaseAdapter {
	private Activity c;
	private SharedPreferences prefs;
	public int numItems;
	private File file;
	List<Project> items;

	public SearchListAdapter(Activity a, List<Project> projects) {
		c = a;
		items = projects;
		if (items == null) {
			numItems = 0;
		} else {
			numItems = projects.size();
		}
		Log.d("Andrew", "numItemsSearchServer: " + numItems);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return numItems;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null) {
			vi = c.getLayoutInflater().inflate(R.layout.projlistitem, null);
		}

		TextView title = (TextView) vi.findViewById(R.id.tv_title);
		title.setText(items.get(position).getName());
		return vi;
	}

}
