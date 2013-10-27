package com.gekkotta.productions.knit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ProjectList extends Activity {
	int index;
	ListView list;
	Button newProj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projlist);

		list = (ListView) findViewById(R.id.list);
		list.setAdapter(new ProjectListAdapter(this));

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				index = list.getFirstVisiblePosition();
				Intent i = new Intent("com.gekkotta.productions.knit.KNIT");
				startActivity(i);
			}
		});

		newProj = (Button) findViewById(R.id.b_newProject);
		newProj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList projItems = null;
				File file = new File(getDir("data", MODE_PRIVATE),
						"projItemList");
				try {
					ObjectInputStream inputStream = new ObjectInputStream(
							new FileInputStream(file));
					projItems = (ArrayList) inputStream.readObject();
					int projectID = 9001;
					projItems.add(projectID);
				} catch (StreamCorruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream(file));
					outputStream.writeObject(projItems);
					outputStream.flush();
					outputStream.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
				Intent i = new Intent("com.gekkotta.productions.knit.SEARCH");
				startActivity(i);
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
