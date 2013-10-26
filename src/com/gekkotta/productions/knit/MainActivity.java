package com.gekkotta.productions.knit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//Typical menu
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button guess = (Button) findViewById(R.id.b_guess);
		Button projlist = (Button) findViewById(R.id.b_projlist);
		Button credits = (Button) findViewById(R.id.b_credits);
		Button search = (Button) findViewById(R.id.b_search);
		
		guess.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.gekkotta.productions.knit.KNIT");
				startActivity(i);
			}
		});
		projlist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.gekkotta.productions.knit.PROJECTLIST");
				startActivity(i);
			}
		});
		
		credits.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Intent i = new Intent("com.gekkotta.productions.knit.Credits");
			//	startActivity(i);
			}
		});
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.gekkotta.productions.knit.SEARCH");
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
