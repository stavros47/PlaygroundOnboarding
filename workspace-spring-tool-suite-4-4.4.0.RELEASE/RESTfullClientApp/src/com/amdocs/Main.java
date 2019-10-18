package com.amdocs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;

public class Main {

	public static void main(String[] args) {
		
		HttpHost proxy = new HttpHost("192.168.101.52", 8080, "http");
		
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

		HttpGet request = new HttpGet("http://dummy.restapiexample.com/api/v1/employees");
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
