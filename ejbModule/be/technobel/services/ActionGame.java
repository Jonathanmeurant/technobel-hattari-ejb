package be.technobel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.technobel.domain.datamodel.GameState;
import be.technobel.domain.entity.User;

public class ActionGame {
	
	public static void intializeGame(List<User> users)
	{
		GameState gamestate= new GameState();
		gamestate.setUser(users);
		gamestate.setCurrentPlayer(0);
		List<Integer> listNbre = new ArrayList<Integer>();
		for(int i=0; i<8;i++)
		{
			listNbre.add(i);
		}
		
		int [] randomValues = new int[listNbre.size()];
		Random random = new Random();
		int pos =0;
		
		while(listNbre.size()>0)
		{
			
		}
	}
	
	public static void turnClue()
	{
		
	}
	
	public static void firstPlayer()
	{
		
	}
	
	public static void accusation()
	{
		
	}
}
