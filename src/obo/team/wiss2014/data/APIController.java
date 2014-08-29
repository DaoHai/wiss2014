package obo.team.wiss2014.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gwt.dev.protobuf.Message;

public class APIController {
	
	private APIClient client = null;
	public APIController() {
		client = new APIClient();
	}
	
//	public HttpResponse getCategories(String url){
//		HttpResponse response = client.processRequest(url);
//		return response;
//	}
//	
//	public HttpResponse getAvailableDatasets(String url){
//		HttpResponse response = client.processRequest(url);
//		return response;
//	}
//	
//	public HttpResponse getForces(String url){
//		HttpResponse response = client.processRequest(url);
//		return response;
//	}
	
	public List<Category> getCategories(){
		String url = "http://data.police.uk/api/crime-categories?date=2011-08";
		InputStream stream = client.processForStream(url);
		JsonReader reader;
		List<Category> categories = new ArrayList<Category>();
		try {
			reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
			Gson gson = new GsonBuilder().create();
	        reader.beginArray();
	        while (reader.hasNext()) {
	            Category category = gson.fromJson (reader, Category.class);
//	            System.out.println(category);
	            categories.add(category);
	        }
	        reader.endArray();
	        reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return categories;
	}
	
	public List<Dataset> getAvailableDataset(){
		String url = "http://data.police.uk/api/crimes-street-dates";
		InputStream stream = client.processForStream(url);
		JsonReader reader;
		List<Dataset> datasets = new ArrayList<Dataset>();
		try {
			reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
			Gson gson = new GsonBuilder().create();
	        reader.beginArray();
	        while (reader.hasNext()) {
	            Dataset dataset = gson.fromJson (reader, Dataset.class);
//	            System.out.println(category);
	            datasets.add(dataset);
	        }
	        reader.endArray();
	        reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return datasets;
	}
	
	public List<Force> getForce(){
		String url = "http://data.police.uk/api/forces";
		InputStream stream = client.processForStream(url);
		JsonReader reader;
		List<Force> forces = new ArrayList<Force>();
		try {
			reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
			Gson gson = new GsonBuilder().create();
	        reader.beginArray();
	        while (reader.hasNext()) {
	            Force force = gson.fromJson(reader, Force.class);
//	            System.out.println(category);
	            forces.add(force);
	        }
	        reader.endArray();
	        reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return forces;
	}

}
