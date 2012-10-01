package be.technobel.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author student
 *
 */

@Entity
@Table(name="CHIPS")
public class Chips {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CHIPS_ID")
	private Integer id;
	@Column(name ="CHIPS_NAME")
	private String Name;
	@Column(name ="CHIPS_IMAGE_RECTO")
	private String imageRecto;
	@Column(name ="CHIPS_IMAGE_BACK")
	private String imageBack;
	@Transient
	private Boolean reversed;

	public Chips() { }

	public Chips(String name, String imageRecto, String imageBack) {
		super();
		Name = name;
		this.imageRecto = imageRecto;
		this.imageBack = imageBack;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImageRecto() {
		return imageRecto;
	}

	public void setImageRecto(String imageRecto) {
		this.imageRecto = imageRecto;
	}

	public String getImageBack() {
		return imageBack;
	}

	public void setImageBack(String imageBack) {
		this.imageBack = imageBack;
	}
	
}
