package obo.team.wiss2014.data;

import java.io.InputStream;

import org.apache.http.HttpResponse;

public class APIController {
	
	private APIClient client = null;
	public APIController() {
		client = new APIClient();
	}
	
	public HttpResponse getCategories(String url){
		HttpResponse response = client.processRequest(url);
		return response;
	}
	
	public HttpResponse getAvailableDatasets(String url){
		HttpResponse response = client.processRequest(url);
		return response;
	}
	
	public HttpResponse getForces(String url){
		HttpResponse response = client.processRequest(url);
		return response;
	}
	
	public InputStream getCategoriesStream(){
		String url = "http://data.police.uk/api/crime-categories?date=2011-08";
		InputStream stream = client.processForStream(url);
		return stream;
	}
	
	public InputStream getAvailableDatasetStream(){
		String url = "http://data.police.uk/api/crimes-street-dates";
		InputStream stream = client.processForStream(url);
		return stream;
	}
	
	public InputStream getForceStream(){
		String url = "http://data.police.uk/api/forces";
		InputStream stream = client.processForStream(url);
		return stream;
	}

}
