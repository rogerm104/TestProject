package com.rogerproj.httpSSLClinet;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

public class HTTPsConnectionService {
	private CloseableHttpClient httpClient;
	private CloseableHttpResponse  response;
	private RequestConfig requestConfig;
	private static Logger log = Logger.getLogger(HTTPsConnectionService.class);

	public Object ExecuteRequuest(String reqURL,String ip, int port){
		
		return null;
		
	}
	
}
