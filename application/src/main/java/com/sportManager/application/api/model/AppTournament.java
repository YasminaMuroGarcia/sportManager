package com.sportManager.application.api.model;

import java.util.UUID;

public class AppTournament {

	private UUID id;
	private String name;
	private UUID gameReference;
	private String contestantType;
	private Integer numberPlayers;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getGameReference() {
		return gameReference;
	}
	public void setGameReference(UUID gameReference) {
		this.gameReference = gameReference;
	}
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
	public Integer getNumberPlayers() {
		return numberPlayers;
	}
	public void setNumberPlayers(Integer numberPlayers) {
		this.numberPlayers = numberPlayers;
	}
	
}
