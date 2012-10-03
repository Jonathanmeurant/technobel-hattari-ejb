package be.technobel.domain.datamodel;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {
	private int nbrMaxPlayer;
	
	private List<ConnectedUser> connectedUsers;  //Liste des Users avec en plus leur adresse IP, si c'est à lui d'accuser (isPlying) et si'il est loggué.
	private int nbrPlayer;  //Nombre de player loggé dans le jeu
	private int loopCounter; //Compteur de Tour lors de la phase Accusation
	private int roundCounter; //Comptage de Round
	private boolean isPoolPlayerFull; //Est-ce que tous les joueurs sont loggés (Dans la liste connectedUsers
	private boolean isInitialized; // Est-xce que le jeu est initialisé
	private int nbrWaitToTurnClue; // Nombre de joueur en attente pour le TurnClue 
	private List<String> userListIpWaitTurn; //Liste des User en attente du turnclue
	private boolean isTurnClue; // Est-ce que le turnClue a été active
	private int currentPlayer;
	private boolean isOnFirstPlayer;
	private boolean isOnAccusation;

	public GameLoop() {
		connectedUsers = new ArrayList<ConnectedUser>();
		userListIpWaitTurn = new ArrayList<String>();
		this.nbrMaxPlayer = 4;
		this.setNbrPlayer(0);
		this.setLoopCounter(0);
		this.setPoolPlayerFull(false);
		this.setRoundCounter(0);
		this.setInitialized(false);
		this.setTurnClue(false);
		this.setCurrentPlayer(0);
	}

	public List<String> getUserListIpWaitTurn() {
		return userListIpWaitTurn;
	}

	public void setUserListIpWaitTurn(List<String> userListIpWaitTurn) {
		this.userListIpWaitTurn = userListIpWaitTurn;
	}
	
	public void addUserListIpWaitTurn(String userIp) {
		this.userListIpWaitTurn.add(userIp);
	}

	public int getNbrWaitToTurnClue() {
		return nbrWaitToTurnClue;
	}

	public void setNbrWaitToTurnClue(int nbrWaitToTurnClue) {
		this.nbrWaitToTurnClue = nbrWaitToTurnClue;
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
	
	public void setNbrMaxPlayer(int nbrMaxPlayer) {
		this.nbrMaxPlayer = nbrMaxPlayer;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	public boolean isTurnClue() {
		return isTurnClue;
	}

	public void setTurnClue(boolean isTurnClue) {
		this.isTurnClue = isTurnClue;
	}
	
	public boolean isUserInList (String userIp){
		for(ConnectedUser myConnectedUser : this.getConnectedUsers()) {
			if(myConnectedUser.getUserIP().equals(userIp)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isUserWaitingTurn (String userIp) {
		for(String userIP : this.getUserListIpWaitTurn()) {
			if(userIP.equals(userIp)) {
				return true;
			}
		}
		return false;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public boolean isOnFirstPlayer() {
		return isOnFirstPlayer;
	}

	public void setOnFirstPlayer(boolean isOnFirstPlayer) {
		this.isOnFirstPlayer = isOnFirstPlayer;
	}

	public boolean isOnAccusation() {
		return isOnAccusation;
	}

	public void setOnAccusation(boolean isOnAccusation) {
		this.isOnAccusation = isOnAccusation;
	}


}
