package com.rogerproj.httpSSLClinet;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class MutualHttpsMain {
	public static void main(String[] args) throws Exception {

		System.out.println("Responce => "+getHttpResponseWithSSL("http://dummy.restapiexample.com/api/v1/employees"));
	}
	@SuppressWarnings("resource")
	static String getHttpResponseWithSSL(String url) throws Exception {
		//default truststore parameters
		RequestConfig requestConfig;
		requestConfig = RequestConfig.custom().setConnectTimeout(10).build();
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse  response = null;
		boolean one=false;
		if(one){
			System.setProperty("javax.net.ssl.trustStore", "C:/Program Files (x86)/Java/jre1.8.0_231/lib/security/cacerts");
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			System.setProperty("javax.net.ssl.trustStoreType", "JKS");
			String trustStore = System.getProperty("javax.net.ssl.trustStore");
			System.out.println("trustStore ====" +trustStore);
			//my certificate and password
			//    System.setProperty("javax.net.ssl.keyStore", "C:/Program Files (x86)/Java/jre1.8.0_231/lib/security/cacerts");
			//    System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
			//    System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
			HttpClient httpclient = new HttpClient();
			GetMethod method = new GetMethod();
			method.addRequestHeader("Content-Type", "application/json");
			method.setPath(url);
			int statusCode = httpclient.executeMethod(method);
			System.out.println("Status: " + statusCode);
			method.getResponseBody();	   
			System.out.println( method.getEffectiveVersion().toString());
			System.out.println( method.getResponseFooters());
			System.out.println( method.getParams());
			method.releaseConnection();
			return method.getResponseBodyAsString();
		}else {
				httpClient = new SSLHelper();
				HttpGet httpGet = new HttpGet(url);
				httpGet.addHeader("Content-Type", "application/json");
				httpGet.setConfig(requestConfig);
				try {
					response = httpClient.execute(httpGet);
				}
				catch (IOException e) {
				}
				if(response==null || HttpStatus.SC_OK != response.getStatusLine().getStatusCode())
				{
					if(response!=null) {
						System.out.println(response.getAllHeaders());
						System.out.println(response.getStatusLine());

						}
				}
			return null;
		
	}

}}
