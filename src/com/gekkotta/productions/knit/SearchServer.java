package com.gekkotta.productions.knit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class SearchServer extends Activity{
	EditText searchBar;
	ListView lv;
	ImageButton search;
	String query;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchserver);
		searchBar = (EditText)findViewById(R.id.tv_searchserver);
		lv = (ListView)findViewById(R.id.lv_searchserver);
		SearchListAdapter adapter = new SearchListAdapter(this);
        lv.setAdapter(adapter); 
        search = (ImageButton)findViewById(R.id.ib_search);
        search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				query=searchBar.getText().toString();
				//Send to Server get Results
			}
		});
		
	
	}
}
