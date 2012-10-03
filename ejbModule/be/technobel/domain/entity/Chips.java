package be.technobel.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author jonmeu
 *
 */

@Entity
@Table(name="CHIPS")
@NamedQueries( {
	@NamedQuery(name = "Chips.findByName",
				query = "SELECT c FROM Chips AS c where c.name  like :name")
	} )
public class Chips implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CHIPS_ID")
	private Integer id;
	@Column(name ="CHIPS_NAME")
	private String name; // les noms des jetons = yellow, blue, red, green and firstplayer.
	@Column(name ="CHIPS_IMAGE_RECTO")
	private String imageRecto;
	@Column(name ="CHIPS_IMAGE_BACK")
	private String imageBack;
	@Transient
	private Boolean reversed;

	public Chips() {
		this.reversed=false;
	}
	
	public Chips(Chips chip) {
		this.id=chip.id;
		this.imageBack=chip.imageBack;
		this.imageRecto=chip.imageRecto;
		this.name=chip.name;
		this.reversed=chip.reversed;
	}

	public Chips(String name, String imageRecto, String imageBack) {
		super();
		this.name = name;
		this.imageRecto = imageRecto;
		this.imageBack = imageBack;
		this.reversed=false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getReversed() {
		return reversed;
	}

	public void setReversed(Boolean reversed) {
		this.reversed = reversed;
	}

	@Override
	public Chips clone() throws CloneNotSupportedException {
		return new Chips(this);
	}
	
	
	
}
