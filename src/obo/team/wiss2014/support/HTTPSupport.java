package obo.team.wiss2014.support;

import java.io.BufferedInputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTTPSupport {
	
	public HttpEntity getEntity(HttpResponse response){
		HttpEntity entity = null;
		try {
			entity = response.getEntity();
			byte[] buffer = new byte[1024];
			if (entity == null) {
				// Throw exception
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	public InputStream getStream(HttpEntity entity){
		InputStream entityStream = null;
		try {
			if (entity != null) {
				entityStream = entity.getContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return entityStream;
	}
	
	public void displayStream(InputStream entityStream){
		try {
			byte[] buffer = new byte[1024];
			try {
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(
						entityStream);
				while ((bytesRead = bis.read(buffer)) != -1) {
					String chunk = new String(buffer, 0, bytesRead);
					System.out.println(chunk);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					entityStream.close();
				} catch (Exception ignore) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
