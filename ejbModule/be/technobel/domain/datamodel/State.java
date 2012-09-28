/**
 * 
 */
package be.technobel.domain.datamodel;

/**
 * @author jonmeu
 *
 */
public enum State {
	
	Mort("mort"),
	Suspect("suspect"),
	Temoin("témoin");
	
	private String name;
	
	State(String name){
		this.name=name;
	}

}
