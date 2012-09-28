package be.technobel.domain.datamodel;

/**
 * @author jonmeu
 *
 */

public enum CharacterType {

	innocent("innocent"), 
	inversion("inversion"), 
	autre("autre");
	private String name;
	
	CharacterType(String name)
	{
		this.name = name;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}