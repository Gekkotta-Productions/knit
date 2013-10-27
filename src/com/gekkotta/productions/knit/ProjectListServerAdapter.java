package com.gekkotta.productions.knit;

import java.util.List;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProjectListServerAdapter extends BaseAdapter {
	
	private Activity c;
	List<Project> projects;
	
	public ProjectListServerAdapter(Activity a, List<Project> projects){
		c = a;
		this.projects = projects;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
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
		title.setText(projects.get(position).getName());
		return vi;
	}

}
