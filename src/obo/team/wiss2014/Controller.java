package obo.team.wiss2014;

import org.vaadin.addon.leaflet.LeafletClickEvent;
import org.vaadin.addon.leaflet.LeafletClickListener;
import org.vaadin.addon.leaflet.shared.Point;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.UI;

public class Controller {

	private Wiss2014UI view;
	
	public Controller(Wiss2014UI view){
		
		this.view = view;
		
		view.getMap().addClickListener(new MapClickListener());
		view.getHoursSlider().addValueChangeListener(new HoursSliderListener());
		view.getTypesOfCrimesTable().addItemClickListener(new TypesOfCrimeTableListener());
	}
	
	class MapClickListener implements LeafletClickListener {

		@Override
		public void onClick(LeafletClickEvent event) {
			Point point = event.getPoint();
			view.getDetailedInfoWindow().setLatitude(point.getLat());
			view.getDetailedInfoWindow().setLongitude(point.getLon());
			UI.getCurrent().addWindow(view.getDetailedInfoWindow());
		}
		
	}
	
	class HoursSliderListener implements ValueChangeListener {

		private static final long serialVersionUID = 1L;

		@Override
		public void valueChange(ValueChangeEvent event) {
			// TODO Auto-generated method stub
		}
		
	}
	
	class TypesOfCrimeTableListener implements ItemClickListener {

		private static final long serialVersionUID = 1L;

		@Override
		public void itemClick(ItemClickEvent event) {
			// TODO Auto-generated method stub
		}
		
	}
	
}
