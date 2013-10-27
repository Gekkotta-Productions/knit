package com.gekkotta.productions.knit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ProjectList extends Activity{
	int index;
	ListView list;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projlist);
		list= (ListView)findViewById(R.id.list);
		list.setAdapter(new ProjectListAdapter(this));

		list.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				index = list.getFirstVisiblePosition();
			}
		});
	
	}
	@Override
	public void onResume() {
		super.onResume(); 
		list.setAdapter(new ProjectListAdapter(this));
		list.setSelection(index);
	}
}
