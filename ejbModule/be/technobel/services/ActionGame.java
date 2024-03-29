package be.technobel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.technobel.domain.datamodel.CharacterType;
import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.Character;
import be.technobel.domain.entity.Chips;
import be.technobel.domain.entity.User;
import be.technobel.domain.repository.interfaces.character.CharacterRepository;
import be.technobel.domain.repository.interfaces.chips.ChipsRepository;
import be.technobel.services.interfaces.ActionGameInterface;

@Stateless(name = "actionGame")
public class ActionGame implements ActionGameInterface {
	@EJB
	private CharacterRepository charRepository;
	@EJB
	private ChipsRepository chipsRepository;
	private GameState gamestate = new GameState();

	public GameState getGamestate() {
		return gamestate;
	}

	// --------------------------------------BEGIN GAME----------------------------------------//
	public void intializeGame(List<User> users) {
		gamestate = new GameState();
		gamestate.setUser(users);
		gamestate.setCurrentPlayer(0);
		int nbPlayers = users.size();
		List<Character> listNbre;
		switch (nbPlayers) {
		case 2:
			listNbre = charRepository.findFor2players();
			break;
		case 3:
			listNbre = charRepository.findFor3players();
			break;
		default:
			listNbre = charRepository.findAll();
			break;
		}
			
		gamestate.setLastSelectedCharacter(null);

		Random random = new Random();
		int nbreRandom = 0;
		int pos = 0;
		while (listNbre.size() > 0) {
			nbreRandom = random.nextInt(listNbre.size());

			switch (pos) {
			case 0:
			case 1:
			case 2:
			case 3:
				users.get(pos).setClue(listNbre.get(nbreRandom));
				break;
			case 4:
				gamestate.setVictim(listNbre.get(nbreRandom)); // victime
				break;
			default:
				gamestate.addSuspect(listNbre.get(nbreRandom)); // suspects
				break;
			}
			pos++;
			if(nbPlayers==2 && pos == 2){
				pos = 4;
			}
			if(nbPlayers==3 && pos == 3){
				pos = 4;
			}
			listNbre.remove(nbreRandom);
		}

		// -------InitializeChipsPlayer--------//
		pos = 1;
		int mult = 5;
		Chips chip=null ;
		for (User user : users) {
			switch (pos) {
			case 1:
				chip =chipsRepository.findByName("yellow");
				chip.setUser(user);
				for (int i = 0; i < mult; i++) {
					user.addChip(new Chips(chip));					
				}
				break;
			case 2:
				chip =chipsRepository.findByName("blue");
				chip.setUser(user);
				for (int i = 0; i < mult; i++) {					
					user.addChip(new Chips(chip));
				}
				break;
			case 3:
				chip =chipsRepository.findByName("red");
				chip.setUser(user);
				for (int i = 0; i < mult; i++) {					
					user.addChip(new Chips(chip));
				}
				break;
			case 4:
				chip =chipsRepository.findByName("green");
				chip.setUser(user);
				for (int i = 0; i < mult; i++) {					
					user.addChip(new Chips(chip));
				}
				break;
			}
			pos++;
		}
	}

	public void turnClue() {

		Character back = null;
		Character firstCharacter = null;
		for (User user : gamestate.getUser()) {
			if (firstCharacter == null) {
				firstCharacter = user.getClue();
			} else {
				back = user.getClue();
				user.setClue(firstCharacter);
				firstCharacter = back;
			}
		}
		gamestate.getUser().get(0).setClue(firstCharacter);
	}

	public void firstPlayer(Character character) {
		gamestate.setLastSelectedCharacter(character);
		character.addChips(chipsRepository.findByName("firstplayer"));
	}

	public void accusation(Character suspect) {
		User user = gamestate.getUser().get(gamestate.getCurrentPlayer());
		Chips chips = searchChipsUser(user);
		suspect.getlChips().add(chips);
		user.removeChip(chips);
		gamestate.setLastSelectedCharacter(suspect);
	}

	public Chips searchChipsUser(User user) {
		for (int i = 0; i < user.getChips().size(); i++) {
			if (!user.getChips().get(i).getReversed()) {
				return user.getChips().get(i);
			}
		}
		return null;
	}

	// --------------------------------------ROUND----------------------------------------//
	private Character searchKiller() {
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		Character killerMax = null;
		Character killerMin = null;
		boolean inversion = false;
		List<Character> suspects = gamestate.getSuspects();
		for (Character suspect : suspects) {
			if (suspect.getType().equals(CharacterType.inversion)) {
				inversion = true;
			}
			if (!suspect.getType().equals(CharacterType.innocent)) {
				if (suspect.getNumber() < minimum) {
					minimum = suspect.getNumber();
					killerMin = suspect;
				}
				if (suspect.getNumber() > maximum) {
					maximum = suspect.getNumber();
					killerMax = suspect;
				}
			}
		}
		if (inversion) {
			return killerMin;
		} else {
			return killerMax;
		}
	}
	
	public void sharingChips()
	{
		gamestate.setKiller(searchKiller());
		Character killer = gamestate.getKiller();
		List<Character> suspects=gamestate.getSuspects();
		
		for(Character suspect : suspects){
			List<Chips> tokens = suspect.getlChips();
			
			if(suspect.getlChips().isEmpty())
			{
				continue;
			}
			
			if(suspect.equals(killer))
			{
				for(Chips token : tokens)
				{
					if(token.getName().equalsIgnoreCase("firstplayer")){
						continue;
					}
					User user=token.getUser();
					user.addChip(token);
				}
			}
			else
			{
				User user=tokens.get(tokens.size()-1).getUser();
				for(Chips token : tokens)
				{
					if(token.getName().equalsIgnoreCase("firstplayer")){
						continue;
					}
					user.addChip(token);
					token.setUser(user);
					token.setReversed(true);
				}
			}
			
			suspect.removeChips(tokens);
		}
	}
	
	public void intializeGameRound() {
		gamestate.setCurrentPlayer(0);
		List<User> users = gamestate.getUser();
		int nbPlayers = users.size();
		List<Character> listNbre;
		switch (nbPlayers) {
		case 2:
			listNbre = charRepository.findFor2players();
			break;
		case 3:
			listNbre = charRepository.findFor3players();
			break;
		default:
			listNbre = charRepository.findAll();
			break;
		}
			
		gamestate.setLastSelectedCharacter(null);
		gamestate.getSuspects().clear();

		Random random = new Random();
		int nbreRandom = 0;
		int pos = 0;
		while (listNbre.size() > 0) {
			nbreRandom = random.nextInt(listNbre.size());

			switch (pos) {
			case 0:
			case 1:
			case 2:
			case 3:
				users.get(pos).setClue(listNbre.get(nbreRandom));
				break;
			case 4:
				gamestate.setVictim(listNbre.get(nbreRandom)); // victime
				break;
			default:
				gamestate.addSuspect(listNbre.get(nbreRandom)); // suspects
				break;
			}
			pos++;
			if(nbPlayers==2 && pos == 2){
				pos = 4;
			}
			if(nbPlayers==3 && pos == 3){
				pos = 4;
			}
			listNbre.remove(nbreRandom);
		}
	}

	// --------------------------------------END GAME----------------------------------------//
	public User userWin() {
		User winner = null;
		List<User> winUsers = new ArrayList<User>();
		int minimum = Integer.MAX_VALUE;
		for (User user : gamestate.getUser()) {
			List<Chips> chipsUsers = user.getChips();
			int size = chipsUsers.size();

			if (size < minimum) {
				minimum = size;
				winUsers.clear();
				winUsers.add(user);

			} else if (size == minimum) {
				winUsers.add(user);
			}
		}

		if (winUsers.size() == 1) {
			winner = winUsers.get(0);
			return winner;
		}

		minimum = Integer.MAX_VALUE;
		for (User user : winUsers) {
			int blackChips = 0;
			for (Chips chips : user.getChips()) {
				if (chips.getReversed()) {
					blackChips++;
				}
			}
			if (blackChips < minimum) {
				minimum = blackChips;
				winner = user;
			}
		}

		return winner;
	}

	public boolean endGame() {
		boolean endGame = true;
		for (User user : gamestate.getUser()) {
			endGame = true;
			List<Chips> chipsUser = user.getChips();
			if (chipsUser.size() >= 8 || chipsUser.size() <= 0) {
				break;
			}
			for (Chips chips : chipsUser) {
				if (!chips.getReversed()) {
					endGame = false;
					break;
				}
			}

			if (endGame) {
				break;
			}
		}
		return endGame;

	}
	
	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}
}
