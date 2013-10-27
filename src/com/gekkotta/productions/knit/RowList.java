package com.gekkotta.productions.knit;

import java.net.HttpURLConnection;
import java.net.URL;

public class RowList{

	StringBuffer response;

	public RowList(){
		String target = "http://10.21.157.42/getPatterns.php";
		String urlParametersl = ";
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

		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		response = new StringBuffer();
		while ((line = rd.readLine()) != NULL){
			response.append(line);
			response.append('\r');
		}
		rd.close();
	}
}
