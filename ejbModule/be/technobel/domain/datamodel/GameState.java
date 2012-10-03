package be.technobel.domain.datamodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import be.technobel.domain.entity.Character;
import be.technobel.domain.entity.User;




public class GameState {
	//ATTRIBUTS
	private int currentPlayer = 0;
	private List<User> user;
	private Character victim;
	private List<Character> suspects = new ArrayList<Character>();
	private Character lastSelectedCharacter;
	private boolean endGame=false;
	//CONSTRUCTEUR
	public GameState() {}

	
	//METHODES
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
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
	
	public void addSuspect(Character suspect)
	{
		this.suspects.add(suspect);
	}

	public Character getLastSelectedCharacter() {
		return lastSelectedCharacter;
	}

	public void setLastSelectedCharacter(Character lastSelectedCharacter) {
		this.lastSelectedCharacter = lastSelectedCharacter;
	}
	
	
}
