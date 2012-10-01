package domain.game;

import java.util.List;

public class Player {
	
	User user;
	List<PlayerChips> usableTokens;
	List<PlayerChips> unusableTokens;
	Character clue;
	
	public Player(User user, Token token)
	{
		this.user=user;
		for(int i=0;i<5;i++)
		{
			usableTokens.add(new PlayerChips(token, user));
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PlayerChips> getUsableTokens() {
		return usableTokens;
	}

	public void setUsableTokens(List<PlayerChips> usableTokens) {
		this.usableTokens = usableTokens;
	}

	public List<PlayerChips> getUnusableTokens() {
		return unusableTokens;
	}

	public void setUnusableTokens(List<PlayerChips> unusableTokens) {
		this.unusableTokens = unusableTokens;
	}

	public Character getClue() {
		return clue;
	}

	public void setClue(Character clue) {
		this.clue = clue;
	}
	
	

}
