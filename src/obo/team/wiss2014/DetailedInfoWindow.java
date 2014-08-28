package obo.team.wiss2014;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class DetailedInfoWindow extends Window {

	private static final long serialVersionUID = 1L;
	
	private static final Label text = new Label("Here are some more detailed on this crime:");
	private static final Label latitudeLabel = new Label();
	private static final Label longitudeLabel = new Label();
	
	public DetailedInfoWindow(){
		
		super("Detailed information");
		
		final VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setMargin(true);
		rootLayout.addComponent(text);
		rootLayout.addComponent(latitudeLabel);
		rootLayout.addComponent(longitudeLabel);

		this.setWidth(500, Unit.PIXELS);
		this.center();
		this.setModal(true);
		this.setContent(rootLayout);
		this.setClosable(true);
		
	}
	
	public void setLatitude(Double latitude){
		latitudeLabel.setCaption("Latitude: " + latitude.toString());
	}
	
	public void setLongitude(Double longitude){
		longitudeLabel.setCaption("Longitude: " + longitude.toString());
	}

}
