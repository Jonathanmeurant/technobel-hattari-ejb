package be.technobel.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.technobel.domain.datamodel.CharacterType;

/**
 * @author jonmeu
 *
 */

@Entity
@Table(name="CHARACTER")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CHARACTER_ID")
	private Integer id;
	@Column(name ="CHARACTER_IMAGE")
	private String image;
	@Column(name ="CHARACTER_NUMBER")
	private Integer number;	
	@Column(name ="CHARACTER_TYPE")
	private CharacterType Type;
	
	
	public Character() { }

	public Character(Integer id, String image, Integer number,
			CharacterType type) {
		super();
		this.id = id;
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
	
	
	
}
