package obo.team.wiss2014.data;

import java.io.BufferedInputStream;
import java.io.InputStream;

import obo.team.wiss2014.support.HTTPSupport;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class APIClient {

	public HttpResponse processRequest(String url) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			HttpGet httpGetRequest = new HttpGet(url);
			httpResponse = httpClient.execute(httpGetRequest);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return httpResponse;
	}
	
	public InputStream processForStream(String url) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		InputStream stream = null;
		HTTPSupport support = new HTTPSupport();
		try {
			HttpGet httpGetRequest = new HttpGet(url);
			httpResponse = httpClient.execute(httpGetRequest);
			HttpEntity entity = support.getEntity(httpResponse);
			stream = support.getStream(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return stream;
	}

}
