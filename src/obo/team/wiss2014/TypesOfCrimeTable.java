package obo.team.wiss2014;

import com.vaadin.ui.Table;

public class TypesOfCrimeTable extends Table {

	private static final long serialVersionUID = 1L;
	
	public TypesOfCrimeTable(){
		
		super();
		
		this.addContainerProperty("Types of crime", String.class, null);
		populateCrimeTypes();
		this.setSizeFull();
	}
	
	public void populateCrimeTypes(){
		
	}
	
}
