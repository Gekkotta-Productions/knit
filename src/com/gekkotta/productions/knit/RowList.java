package com.gekkotta.productions.knit;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class RowList{

	public StringBuffer response;

	public RowList() throws IOException{
		String target = "http://10.21.157.42/getPattern.php";
		String urlParameters = "";
		URL url;
		HttpURLConnection connection = null;
		url = new URL(target);
		connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		
		connection.setRequestProperty("Content-Length", ""+Integer.toString(urlParameters.getBytes().length));
		connection.setRequestProperty("Content-Language", "en-US");
		
		connection.setUseCaches (false);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes (urlParameters);
		wr.flush();
		wr.close();

		Log.e("SWAG", "" + connection.getResponseCode());
		
		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		response = new StringBuffer();
		while ((line = rd.readLine()) != null){
			response.append(line);
			response.append('\r');
		}
		rd.close();
	}
	
	public String getWord(){
		return response.toString();
	}
}
