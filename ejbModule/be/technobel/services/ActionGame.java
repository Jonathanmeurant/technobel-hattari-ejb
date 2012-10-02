package be.technobel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;

import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.Character;
import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.character.CharacterRepository;
import be.technobel.domain.repository.interfaces.chips.ChipsRepository;

public class ActionGame {
	@EJB
	private CharacterRepository charRepository;
	@EJB
	private ChipsRepository chipsRepository;
	GameState gamestate = new GameState();
	public void intializeGame(List<User> users) {
		
		gamestate.setUser(users);
		gamestate.setCurrentPlayer(0);
		List<Character> listNbre = charRepository.findAll();
		gamestate.setLastSelectedCharacter(null);

		Random random = new Random();
		int nbreRandom = 0;
		int pos = 0;
		while (listNbre.size() > 0) {
			nbreRandom = random.nextInt(listNbre.size());

			switch (pos) {
			case 1:
			case 2:
			case 3:
			case 4:
				users.get(pos).setClue(listNbre.get(nbreRandom));
				break;
			case 5:
				gamestate.setVictim(listNbre.get(nbreRandom)); // victime
				break;
			default:
				gamestate.addSuspect(listNbre.get(nbreRandom)); // suspects
				break;
			}
			pos++;
			listNbre.remove(nbreRandom);
		}
		
		//-------InitializeChipsPlayer--------//
		pos=1;
		int mult=5;
		for(User user : users)
		{
			List<Chips> userChips = new ArrayList<>();
			switch(pos)
			{
			case 1:
				for(int i=0; i<mult; i++)
				{	
					userChips.add(chipsRepository.findByName("yellow"));
					user.setChips(userChips);
				}
				break;
			case 2:
				for(int i=0; i<mult; i++)
				{	
					userChips.add(chipsRepository.findByName("blue"));
					user.setChips(userChips);
				}
				break;
			case 3:
				for(int i=0; i<mult; i++)
				{	
					userChips.add(chipsRepository.findByName("red"));
					user.setChips(userChips);
				}
				break;
			case 4:
				for(int i=0; i<mult; i++)
				{	
					userChips.add(chipsRepository.findByName("green"));
					user.setChips(userChips);
				}
				break;
			}
			pos++;
		}
		
	}

	public void turnClue() {

		Character back =null;
		Character firstCharacter=null;
		for (User user:gamestate.getUser()){
			if (firstCharacter==null)
			{
				firstCharacter=user.getClue();
			}
			else
			{
				back=user.getClue();
				user.setClue(firstCharacter);
				firstCharacter = back;
			}
		}
		gamestate.getUser().get(0).setClue(firstCharacter);
	}

	public void firstPlayer(Character character) {
		gamestate.setLastSelectedCharacter(character);
		character.getlChips().add(chipsRepository.findByName("firstplayer"));
		
		
	}

	public void accusation(Character suspect) {
		User user=gamestate.getUser().get(gamestate.getCurrentPlayer());
		Chips chips=searchChipsUser(user);
		suspect.getlChips().add(chips);
		user.getChips().remove(chips);
		gamestate.setLastSelectedCharacter(suspect);
	}
	
	public Chips searchChipsUser(User user)
	{
		for(int i=0; i<user.getChips().size();i++)
		{
			if(!user.getChips().get(i).getReversed())
			{
				return user.getChips().get(i);
			}
		}
		return null;
	}
}
