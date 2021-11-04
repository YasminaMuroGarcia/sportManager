package com.sportManager.ui.viewModel;

public class TournamentViewModel {

	private String id;
	private String name;
	private String contestantType;
	private String gameId;
	private String numberPlayers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContestantType() {
		return contestantType;
	}
	public void setContestantType(String contestantType) {
		this.contestantType = contestantType;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getNumberPlayers() {
		return numberPlayers;
	}
	public void setNumberPlayers(String numberPlayers) {
		this.numberPlayers = numberPlayers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
