package domain.game;

import java.util.LinkedList;
import java.util.List;

public class GameState {
	
	private int gameStep = 0;
	private int round = 0;
	private int currentPlayer = 0;
	
	private List<Player> players;
		
	private Character victim;
	private List<Character> suspects = new LinkedList<Character>();
	private LinkedList<LinkedList<PlayerChips>> suspectTokens = new LinkedList<LinkedList<PlayerChips>>();
	
	private int firstTokenSuspect;

	public GameState() {}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Character getVictim() {
		return victim;
	}

	public void setVictim(Character victim) {
		this.victim = victim;
	}

	public List<Character> getSuspects() {
		return suspects;
	}

	public void setSuspects(List<Character> suspects) {
		this.suspects = suspects;
	}

	public LinkedList<LinkedList<PlayerChips>> getSuspectTokens() {
		return suspectTokens;
	}

	public void setSuspectTokens(LinkedList<LinkedList<PlayerChips>> suspectTokens) {
		this.suspectTokens = suspectTokens;
	}

	public int getFirstTokenSuspect() {
		return firstTokenSuspect;
	}

	public void setFirstTokenSuspect(int firstTokenSuspect) {
		this.firstTokenSuspect = firstTokenSuspect;
	}

}