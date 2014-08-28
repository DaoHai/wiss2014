package obo.team.wiss2014.data;

import java.io.BufferedInputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class APIClient {

	public HttpResponse getCategories(String url) {

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

}
