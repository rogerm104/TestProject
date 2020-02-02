package com.roger.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestGETMethod {
	public static void main(String[] args) throws IOException {

		//	URL url = new URL("http://localhost:5151/RestWB/restwb/data");
		System.out.println(" system prop "+System.getProperties().getProperty("sun.boot.library.path"));
		StringBuilder result = new StringBuilder();
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		String proxy; int port;
		String wsTaxIdURL ="https://dummy.restapiexample.com/api/v1/employees";
		//wsTaxIdURL=wsTaxIdURL.replace("{taxID}","999999999");
		System.out.println("Modified url= "+wsTaxIdURL);
		URL url = new URL(wsTaxIdURL);
		boolean proxyEnabled=false;
		if(!proxyEnabled)
		{
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Roger Browser");
			conn.setRequestProperty("Accept", ",application/json");
			conn.setRequestProperty("Accept-Language", "en-EN,en");

			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} 
		else{

		}
		try{
			String line;

			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}}else{
					System.out.println(" Not 200 ok");
				}}catch(Exception ex){
					System.out.println("Exception has occured!!!"+ex.getStackTrace());
				}
		finally{
			try{
				rd.close();
			}catch(Exception ex){
				System.out.println("Exception while closing RD"+ex.getStackTrace());
			}
		}

		System.out.println("Responce Code >> "+conn.getResponseCode());
		System.out.println("Responce result >> "+result.toString());
	}
}
