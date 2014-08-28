package obo.team.wiss2014;

import java.net.URI;
import java.util.Date;

import org.semanticweb.owlapi.model.IRI;

public class Crime {

	private IRI iri;
	private double latitude;
	private double longitude;
	private String type;
	private Date date;
	
	public Crime(){
		
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the iri
	 */
	public IRI getIri() {
		return iri;
	}

	/**
	 * @param iri the iri to set
	 */
	public void setIri(IRI iri) {
		this.iri = iri;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Crime){
			return this.getIri().equals(((Crime)o).getIri());
		}
		return false;
	}
	
}
