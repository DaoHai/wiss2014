package obo.team.wiss2014.data;

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

}
