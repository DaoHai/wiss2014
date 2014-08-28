package obo.team.wiss2014;

import java.util.Collection;

public class Model {
	
	private Collection<Crime> crimes;
	
	public Model(){
		
	}

	/**
	 * @return the crimes
	 */
	public Collection<Crime> getCrimes() {
		return crimes;
	}

	/**
	 * @param crimes the crimes to set
	 */
	public void setCrimes(Collection<Crime> crimes) {
		this.crimes = crimes;
	}
	
	public void addCrime(Crime crime){
//		crimes.add(e);
	}

}
