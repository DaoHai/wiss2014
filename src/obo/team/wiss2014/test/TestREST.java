package obo.team.wiss2014.test;

import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import com.google.gwt.dev.protobuf.Message;

import obo.team.wiss2014.data.APIClient;
import obo.team.wiss2014.data.APIController;
import obo.team.wiss2014.data.Category;
import obo.team.wiss2014.data.Dataset;
import obo.team.wiss2014.data.Force;
import obo.team.wiss2014.support.HTTPSupport;

public class TestREST {
	
	public static void main(String[] args){
		HTTPSupport support = new HTTPSupport();
		APIClient client = new APIClient();
		APIController controller = new APIController();
//		List<Category> categories = controller.getCategoriesStream();
//		for (Category category : categories) {
//			System.out.println(category);
//		}
//		List<Force> forces = controller.getForce();
//		for (Force force : forces) {
//			System.out.println(force);
//		}
		List<Dataset> datasets = controller.getAvailableDataset();
		for (Dataset dataset : datasets) {
			System.out.println(dataset);
		}
	}

}
