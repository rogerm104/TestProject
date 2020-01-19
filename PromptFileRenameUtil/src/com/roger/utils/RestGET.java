package com.roger.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class RestGET {
	public static void main(String[] args) throws IOException{
		
	
		URL url = new URL("");
		String query = "name=Ram";
		//make connection
		URLConnection urlc = url.openConnection();
		//System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		//use post mode
		urlc.setDoOutput(true);
		urlc.setAllowUserInteraction(false);

		//send query
		PrintStream ps = new PrintStream(urlc.getOutputStream());
		ps.print(query);
		ps.close();

		//get result
		BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		String l = null;
		while ((l=br.readLine())!=null) {
			System.out.println("Output is >>"+l);		}
		br.close();
	}
}