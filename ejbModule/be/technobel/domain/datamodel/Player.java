package domain.game;

import java.util.List;

public class Player {
	
	User user;
	List<PlayerToken> usableTokens;
	List<PlayerToken> unusableTokens;
	Character clue;
	
	public Player(User user, Token token)
	{
		this.user=user;
		for(int i=0;i<5;i++)
		{
			usableTokens.add(new PlayerToken(token, user));
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PlayerToken> getUsableTokens() {
		return usableTokens;
	}

	public void setUsableTokens(List<PlayerToken> usableTokens) {
		this.usableTokens = usableTokens;
	}

	public List<PlayerToken> getUnusableTokens() {
		return unusableTokens;
	}

	public void setUnusableTokens(List<PlayerToken> unusableTokens) {
		this.unusableTokens = unusableTokens;
	}

	public Character getClue() {
		return clue;
	}

	public void setClue(Character clue) {
		this.clue = clue;
	}
	
	

}
