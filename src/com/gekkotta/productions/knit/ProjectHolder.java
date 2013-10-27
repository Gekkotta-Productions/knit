package com.gekkotta.productions.knit;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class ProjectHolder {
	
	private static final String URL = "http://10.21.157.42/getList.php";

	public ProjectHolder(){
		
	}
	
	List<Project> fetchProjects(){
		//
		String raw = RemoteData.readContents(URL);
		
		Log.d("Andrew", "Andy: " + raw);
		List<Project> list = new ArrayList<Project>();
		try {
			JSONObject data = new JSONObject(raw).getJSONObject("data");
			JSONArray children = data.getJSONArray("children");
			
			for(int i = 0; i < children.length(); i++) {
                JSONObject cur = children.getJSONObject(i).getJSONObject("data");
                Project p = new Project();
                p.name = cur.optString("name");
                p.description = cur.optString("description");
                p.author = cur.optString("author");
                p.needleType = cur.getString("needleType");
                p.id = cur.getInt("projID");
                p.plength = cur.getInt("length");
                p.needleSize = cur.getInt("needleSize");
                if(p.name != null) {
                    list.add(p);
                }
            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
