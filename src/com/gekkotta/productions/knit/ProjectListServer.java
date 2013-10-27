package com.gekkotta.productions.knit;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProjectListServer extends Activity{

	ListView projList;
    ArrayAdapter<Project> adapter;
    Handler handler;
    private static String URL = "http://192.168.1.104/getList.php?q=1";
    String subreddit;
    List<Project> projects;
    ProjectHolder projHolder;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectlist);
        ProjectHolder ph = new ProjectHolder(URL);
        projects = ph.fetchProjects();
		projList = (ListView)findViewById(R.id.list2);
		projList.setAdapter(new ProjectListServerAdapter(this, projects));
    }
    
    public void onResume() {
		super.onResume(); 
		projList.setAdapter(new ProjectListServerAdapter(this, projects));
	}
	
}
