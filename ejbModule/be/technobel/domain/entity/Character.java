package be.technobel.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import be.technobel.domain.datamodel.CharacterType;

/**
 * @author jonmeu
 *
 */

@Entity
@Table(name="CHARACTER_HT")
@NamedQueries({
	@NamedQuery(name = "Character.findFor2Players", query = "select c from Character c where not c.number = 2 and not c.number = 8 or c.number is null"),
	@NamedQuery(name = "Character.findFor3Players", query = "select c from Character c where not c.number = 2 or c.number is null")
})
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CHARACTER_HT_ID")
	private Integer id;
	@Column(name ="CHARACTER_HT_IMAGE")
	private String image;
	@Column(name ="CHARACTER_HT_NUMBER", nullable =true) //nom de la colonne en base de données
	private Integer number;
	@Enumerated(value = EnumType.STRING) 
	@Column(name ="CHARACTER_HT_TYPE")
	private CharacterType Type;
	@Transient
	private  Boolean visible;
	@Transient
	private List<Chips> lChips =new ArrayList<Chips>();
	

	public Character() { }

	public Character(String image, Integer number,
			CharacterType type) {
		super();
		this.image = image;
		this.number = number;
		Type = type;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public CharacterType getType() {
		return Type;
	}

	public void setType(CharacterType type) {
		Type = type;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	
	public List<Chips> getlChips() {
		return lChips;
	}

	public void setlChips(List<Chips> lChips) {
		this.lChips = lChips;
	}
	
	public void addChips(Chips chips){
		lChips.add(chips);
	}
	
	
	
}
