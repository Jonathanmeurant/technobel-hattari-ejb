package be.technobel.domain.datamodel;

import java.util.List;

public class GameLoop {
	private int nbrMaxPlayer;
	
	private List<ConnectedUser> connectedUsers;
	private int nbrPlayer;
	private int loopCounter;
	private int roundCounter;
	private boolean isPoolPlayerFull;
	private boolean isInitialized;
	

	public GameLoop() {
		this.nbrMaxPlayer = 4;
		this.setNbrPlayer(0);
		this.setLoopCounter(0);
		this.setPoolPlayerFull(false);
		this.setRoundCounter(0);
		this.setInitialized(false);
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
	
	public void addConnectedUser(ConnectedUser connectedUser) {
		this.connectedUsers.add(connectedUser);
	}

	public boolean isPoolPlayerFull() {
		return isPoolPlayerFull;
	}

	public void setPoolPlayerFull(boolean isPoolPlayerFull) {
		this.isPoolPlayerFull = isPoolPlayerFull;
	}

	public int getNbrPlayer() {
		return nbrPlayer;
	}

	public void setNbrPlayer(int nbrPlayer) {
		this.nbrPlayer = nbrPlayer;
	}

	public int getNbrMaxPlayer() {
		return nbrMaxPlayer;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}


}
