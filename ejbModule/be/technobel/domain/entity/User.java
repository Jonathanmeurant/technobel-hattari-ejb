package be.technobel.domain.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author jonmeu
 *
 */

@Entity
@Table(name="USER")
@NamedQueries( {
	@NamedQuery(name = "User.findByUsername",
				query = "SELECT u FROM User AS u where u.username  like :username")
	} )
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="USER_ID")
	private Integer id;
	@Column(name ="USER_USERNAME")
	private String username;
	@Column(name ="USER_PASSWORD")
	private String password;
	@Column(name ="USER_FIRSTNAME")
	private String firstName;
	@Column(name ="USER_LASTNAME")
	private String lastName;
	@Column(name ="USER_EMAIL")
	private String email;
	@Column(name ="USER_AVATAR")
	private String avatar;
	
	@OneToOne(mappedBy="user")
	private Score score;
	
	@Transient
	private List<Chips> chips;
	@Transient
	private Character clue; 
	
	public User() { }


	public User(String username, String password, String firstName,
			String lastName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}


	public List<Chips> getChips() {
		return chips;
	}


	public void setChips(List<Chips> chips) {
		this.chips = chips;
	}


	public Character getClue() {
		return clue;
	}


	public void setClue(Character clue) {
		this.clue = clue;
	}
	
	
	
}
