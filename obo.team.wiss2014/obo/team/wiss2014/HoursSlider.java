package obo.team.wiss2014;

import com.vaadin.ui.Slider;

public class HoursSlider extends Slider {

	private static final long serialVersionUID = 1L;
	
	private static final double DEFAULT_VALUE = 1.0;

	public HoursSlider(){
		
		super(1, 12);
		
		this.setValue(DEFAULT_VALUE);
		
		this.setSizeFull();
		
	}
	
}
