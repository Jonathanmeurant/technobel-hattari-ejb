package be.technobel.domain.datamodel;

import be.technobel.domain.entity.User;

public class ConnectedUser extends User {
	private String userIP;
	private boolean isLogged;
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

}
