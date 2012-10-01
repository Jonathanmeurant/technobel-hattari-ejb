package be.technobel.domain.datamodel;



import java.util.List;

import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;

public class Player {
	
	User user;
	List<PlayerChips> usableTokens;
	List<PlayerChips> unusableTokens;
	Character clue;
	
	public Player(User user, Chips chips)
	{
		this.user=user;
		for(int i=0;i<5;i++)
		{
			usableTokens.add(new PlayerChips(chips, user));
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PlayerChips> getUsablechips() {
		return usableTokens;
	}

	public void setUsableTokens(List<PlayerChips> usablechips) {
		this.usableTokens = usableTokens;
	}

	public List<PlayerChips> getUnusablechips() {
		return unusableTokens;
	}

	public void setUnusablechips(List<PlayerChips> unusablechips) {
		this.unusableTokens = unusableTokens;
	}

	public Character getClue() {
		return clue;
	}

	public void setClue(Character clue) {
		this.clue = clue;
	}
	
	

}
