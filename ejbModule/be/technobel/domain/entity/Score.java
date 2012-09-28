package be.technobel.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author student
 *
 */

@Entity
@Table(name="SCORE")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="SCORE_ID")
	private Integer id;
	@Column(name ="SCORE_NBRPLAY")
	private int nbrPlay;
	@Column(name ="SCORE_NBRWIN")
	private int nbrWin;
	@Column(name ="SCORE_RATIO")
	private float ratio;
	
	@OneToOne
	@JoinColumn(name="USER_ID") 
	private User user;
	
	public Score() { }

	public Score(Integer id, int nbrPlay, int nbrWin, float ratio) {
		super();
		this.id = id;
		this.nbrPlay = nbrPlay;
		this.nbrWin = nbrWin;
		this.ratio = ratio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNbrPlay() {
		return nbrPlay;
	}

	public void setNbrPlay(int nbrPlay) {
		this.nbrPlay = nbrPlay;
	}

	public int getNbrWin() {
		return nbrWin;
	}

	public void setNbrWin(int nbrWin) {
		this.nbrWin = nbrWin;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
		
}
