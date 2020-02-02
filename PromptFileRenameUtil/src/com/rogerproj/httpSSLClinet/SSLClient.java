package com.rogerproj.httpSSLClinet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class SSLClient {
	private static String URI_SCHEME="https";
	private final static  int  PORT=443;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
	        SSLContext ctx = SSLContext.getInstance("TLS");
	        TrustManager[] trustManagers = getTrustManagers("jks", new FileInputStream(new File("cacerts")), "changeit");
	        KeyManager[] keyManagers = getKeyManagers("pkcs12", new FileInputStream(new File("clientCert.pfx")), "password");
	        ctx.init(keyManagers, trustManagers, new SecureRandom());
	        SSLSocketFactory factory = new SSLSocketFactory(ctx, new StrictHostnameVerifier());

	        ClientConnectionManager manager = httpClient.getConnectionManager();
	        manager.getSchemeRegistry().register(new Scheme(URI_SCHEME, PORT, factory));
	        
	    }catch(Exception ex){
	    	
	    }
	}
	protected static KeyManager[] getKeyManagers(String keyStoreType, InputStream keyStoreFile, String keyStorePassword) throws Exception {
	    KeyStore keyStore = KeyStore.getInstance(keyStoreType);
	    keyStore.load(keyStoreFile, keyStorePassword.toCharArray());
	    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	    kmf.init(keyStore, keyStorePassword.toCharArray());
	    return kmf.getKeyManagers();
	}

	protected static TrustManager[] getTrustManagers(String trustStoreType, InputStream trustStoreFile, String trustStorePassword) throws Exception {
	    KeyStore trustStore = KeyStore.getInstance(trustStoreType);
	    trustStore.load(trustStoreFile, trustStorePassword.toCharArray());
	    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	    tmf.init(trustStore);
	    return tmf.getTrustManagers();
	}
}
