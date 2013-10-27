package com.gekkotta.productions.knit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProjectListAdapter extends BaseAdapter {
    private Activity c;
	public ProjectListAdapter(Activity a) {
		c = a;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
		if(convertView==null){
			vi = c.getLayoutInflater().inflate(R.layout.projlistitem, null);
			
		}
		TextView title = (TextView)vi.findViewById(R.id.tv_title);
		title.setText("WHAT UP PEEPS!");
		ProgressBar pb = (ProgressBar)vi.findViewById(R.id.pb_progress);
		pb.setProgress(50);
		return vi;
	}

}
