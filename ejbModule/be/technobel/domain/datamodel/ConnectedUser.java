package be.technobel.domain.datamodel;

import be.technobel.domain.entity.User;

public class ConnectedUser extends User {
	//Liste des Users avec en plus leur adresse IP, si c'est à lui d'accuser (isPlying) et si'il est loggué.
	private String userIP;
	private boolean isLogged;
	private boolean isWaitingInit;
	private boolean isWaitingTurnClue;
	private boolean isPlaying;

	public ConnectedUser() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserIP() {
		return userIP;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public boolean isWaitingInit() {
		return isWaitingInit;
	}

	public void setWaitingInit(boolean isWaitingInit) {
		this.isWaitingInit = isWaitingInit;
	}

	public boolean isWaitingTurnClue() {
		return isWaitingTurnClue;
	}

	public void setWaitingTurnClue(boolean isWaitingTurnClue) {
		this.isWaitingTurnClue = isWaitingTurnClue;
	}

}
