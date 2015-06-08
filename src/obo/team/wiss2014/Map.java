%Map Info from OpenStreet

package obo.team.wiss2014;

import java.util.Collection;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.shared.Point;

import com.vividsolutions.jts.geom.Coordinate;

public class Map extends LMap {

	private static final long serialVersionUID = 1L;

	public static final Coordinate DEFAULT_CENTER = new Coordinate(51.521165, -0.128378); // LONDON
	public static final int DEFAULT_ZOOM_LEVEL = 8;
	public static final String OSM_LAYER_NAME = "OpenStreetMap";
	public static final String OSM_ATTRIBUTION = "Powered by Leaflet with v-leaflet";
	
	public Map(){
		
		super();
		
		this.setAttributionPrefix(OSM_ATTRIBUTION);
		this.addBaseLayer(new LOpenStreetMapLayer(), OSM_LAYER_NAME);
		this.setZoomLevel(DEFAULT_ZOOM_LEVEL);
		this.setCenter(DEFAULT_CENTER.x, DEFAULT_CENTER.y);
		this.setSizeFull();
		
	}
	
	public void addMarkers(Collection<Point> points){
		
		for(Point point : points){
			LMarker marker = new LMarker(point);
			this.addComponent(marker);
		}
		
	}
	
}
