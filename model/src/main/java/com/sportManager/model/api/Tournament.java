package com.sportManager.model.api;

import java.util.UUID;

import com.sportManager.infrastructure.model.Entity;

public interface Tournament extends Entity{

	String getName();
	void setName(String name);
	
	UUID getGameReference();
	void setGameReference(UUID gameReference);
	
	String getContestantType();
	void setContestantType(String contestantType);
	
	Integer getNumberPlayers();
	void setNumberPlayers(Integer numberPlayers);
}
