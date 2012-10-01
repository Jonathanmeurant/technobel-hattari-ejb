package be.technobel.domain.datamodel;

import java.util.List;

public class GameLoop {
	int nbrMaxPlayer = 4;
	
	private List<ConnectedUser> connectedUsers;
	private int loopCounter;
	private int roundCounter;
	

	public GameLoop() {
		// TODO Auto-generated constructor stub
	}

	public int getLoopCounter() {
		return loopCounter;
	}


	public void setLoopCounter(int loopCounter) {
		this.loopCounter = loopCounter;
	}


	public int getRoundCounter() {
		return roundCounter;
	}


	public void setRoundCounter(int roundCounter) {
		this.roundCounter = roundCounter;
	}

	public List<ConnectedUser> getConnectedUsers() {
		return connectedUsers;
	}

	public void setConnectedUsers(List<ConnectedUser> connectedUsers) {
		this.connectedUsers = connectedUsers;
	}

}
