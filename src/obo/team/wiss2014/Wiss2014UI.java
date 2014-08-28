package obo.team.wiss2014;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
@Theme("wiss2014")
public class Wiss2014UI extends UI {

	public static final Coordinate DEFAULT_CENTER = new Coordinate(45.1841656,5.7155425);
	public static final int DEFAULT_ZOOM_LEVEL = 12;
	public static final String OSM_LAYER_NAME = "OpenStreetMap";
	public static final String OSM_ATTRIBUTION = "Powered by Leaflet with v-leaflet";
	
	public static final LMap map = new LMap();
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Wiss2014UI.class, widgetset = "obo.team.wiss2014.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		Label h1 = new Label("CrimeWatch");
		h1.setStyleName(Reindeer.LABEL_H1);
		
		Label h2 = new Label("WISS2014");
		h2.setStyleName(Reindeer.LABEL_H2);
		
		Label h3 = new Label("OBO team");
		h3.setStyleName(Reindeer.LABEL_SMALL);
		
		map.setAttributionPrefix(OSM_ATTRIBUTION);
		map.addBaseLayer(new LOpenStreetMapLayer(), OSM_LAYER_NAME);
		map.setZoomLevel(DEFAULT_ZOOM_LEVEL);
		map.setCenter(DEFAULT_CENTER.x, DEFAULT_CENTER.y);
		map.setSizeFull();
		
		final VerticalLayout layout = new VerticalLayout();
		
		layout.addComponent(h1);
		layout.setExpandRatio(h1, 0.05f);
		layout.addComponent(h2);
		layout.setExpandRatio(h2, 0.05f);
		layout.addComponent(h3);
		layout.setExpandRatio(h3, 0.05f);
		layout.addComponent(map);
		layout.setExpandRatio(map, 0.85f);
		
		layout.setMargin(true);
		layout.setSizeFull();
		
		this.setContent(layout);
		this.setSizeFull();
	}

}