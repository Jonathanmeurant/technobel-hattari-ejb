package be.technobel.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;


@Local
public interface ActionGameInterface {
	
	public void intializeGame(List<User> users);
	public void turnClue();
	public void firstPlayer(Character character);
	public void accusation(Character suspect);
	public Chips searchChipsUser(User user);

}
