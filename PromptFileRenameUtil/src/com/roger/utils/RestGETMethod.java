package com.roger.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class RestGETMethod {
	public static void main(String[] args) throws IOException {

		//	URL url = new URL("http://localhost:5151/RestWB/restwb/data");
		StringBuilder result = new StringBuilder();
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		String wsTaxIdURL ="http://localhost:5151/RestWB/restwb/data?name={taxID}";
		wsTaxIdURL=wsTaxIdURL.replace("{taxID}","999999999");
		System.out.println("Modified url= "+wsTaxIdURL);
		URL url = new URL(wsTaxIdURL);
		try{
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
