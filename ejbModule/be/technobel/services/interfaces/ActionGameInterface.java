package be.technobel.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.Character;

import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;


@Local
public interface ActionGameInterface {
	
	public void intializeGame(List<User> users);
	public void turnClue();
	public void firstPlayer(Character character);
	public void accusation(Character suspect);
	public Chips searchChipsUser(User user);
	public GameState getGamestate();
	public void setGamestate(GameState gamestate);
	public void sharingChips();
	public void intializeGameRound();
	public User userWin();
	public boolean endGame();

}
