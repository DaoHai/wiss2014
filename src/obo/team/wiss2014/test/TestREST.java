package obo.team.wiss2014.test;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import obo.team.wiss2014.data.APIClient;
import obo.team.wiss2014.data.APIController;
import obo.team.wiss2014.support.HTTPSupport;

public class TestREST {
	
	public static void main(String[] args){
		HTTPSupport support = new HTTPSupport();
		APIClient client = new APIClient();
		APIController controller = new APIController();
		HttpResponse response = controller.getCategories("http://data.police.uk/api/crimes-street-dates");
//		HttpResponse response = client.getCategories("http://data.police.uk/api/crime-categories?date=2011-08");
		HttpEntity entity = support.getEntity(response);
		InputStream stream = support.getStream(entity);
		support.displayStream(stream);
	}

}
