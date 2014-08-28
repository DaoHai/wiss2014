package obo.team.wiss2014;

import java.awt.Panel;
import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
@Theme("wiss2014")
public class Wiss2014UI extends UI {
	
	private static final Map map = new Map();
	private static final HoursSlider hoursSlider = new HoursSlider();
	private static final TypesOfCrimeTable typesOfCrimesTable = new TypesOfCrimeTable();
	
	private static final DetailedInfoWindow detailedInfoWindow = new DetailedInfoWindow();
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Wiss2014UI.class, widgetset = "obo.team.wiss2014.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		Label title = new Label("WISS2014 - iCrimeRates");
		title.setStyleName(Reindeer.LABEL_H1);
		
		Label subtitle = new Label("by OBO team");
		subtitle.setStyleName(Reindeer.LABEL_SMALL);
		
		final VerticalLayout mapAndSliderLayout = new VerticalLayout();
		
		mapAndSliderLayout.addComponent(map);
		mapAndSliderLayout.setExpandRatio(map, 0.9f);
		mapAndSliderLayout.addComponent(hoursSlider);
		mapAndSliderLayout.setExpandRatio(hoursSlider, 0.1f);
		mapAndSliderLayout.setComponentAlignment(hoursSlider, Alignment.MIDDLE_CENTER);
		
		mapAndSliderLayout.setSizeFull();
		
		final HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		horizontalLayout.addComponent(typesOfCrimesTable);
		horizontalLayout.setExpandRatio(typesOfCrimesTable, 0.25f);
		horizontalLayout.addComponent(mapAndSliderLayout);
		horizontalLayout.setExpandRatio(mapAndSliderLayout, 0.75f);
		
		horizontalLayout.setSpacing(true);
		horizontalLayout.setSizeFull();
		
		final VerticalLayout layout = new VerticalLayout();
		
		layout.addComponent(title);
		layout.setExpandRatio(title, 0.05f);
		layout.addComponent(subtitle);
		layout.setExpandRatio(subtitle, 0.05f);
		layout.addComponent(horizontalLayout);
		layout.setExpandRatio(horizontalLayout, 0.9f);
		
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.setSizeFull();
		
		this.setContent(layout);
		this.setSizeFull();
		
		new Controller(this);
	}
	
	public void populateMap(){
		RdfReader reader = new RdfReader(new File("D:\\anthony_docs\\workspace_kepler\\WISS2014\\WebContent\\WEB-INF\\resources\\2013-06-btp-street-csv.rdf"));
		reader.read();
	}
	
	public Map getMap(){
		return map;
	}
	
	public TypesOfCrimeTable getTypesOfCrimesTable(){
		return typesOfCrimesTable;
	}
	
	public HoursSlider getHoursSlider(){
		return hoursSlider;
	}

	public DetailedInfoWindow getDetailedInfoWindow(){
		return detailedInfoWindow;
	}
	
}