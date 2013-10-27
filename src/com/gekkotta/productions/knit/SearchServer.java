package com.gekkotta.productions.knit;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
	ProjectHolder p;
	Activity a;
	SearchListAdapter adapter;
	List<Project> results;
	private static String URL = "http://192.168.1.104/search.php?query=";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchserver);
		a=this;
		searchBar = (EditText)findViewById(R.id.tv_searchserver);
		lv = (ListView)findViewById(R.id.lv_searchserver);
		 adapter = new SearchListAdapter(this, null);
        lv.setAdapter(adapter); 
        p = new ProjectHolder(URL);
        search = (ImageButton)findViewById(R.id.ib_search);
        search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				query=searchBar.getText().toString();
				//Send to Server get Results
				String q =URL+query;
				Log.d("Andrew", "Searching Server at: "+q);
				p.updateURL(q);
				 results = p.fetchProjects();
				Log.d("Andrew", "results num items: " + results.size() );
				if (results == null) {
					Log.d("Andrew", "results was null " );
				} 
				
				adapter = new SearchListAdapter(a,results);
		        lv.setAdapter(adapter); 
			}
		});
		
	
	}
}
