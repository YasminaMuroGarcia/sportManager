package com.sportManager.model.api.repository;

import java.util.List;
import java.util.UUID;

import com.sportManager.model.api.Sport;

public interface SportRepository{
	
	List<? extends Sport> getAllSports();
	
	 UUID addSport(Sport sport);

}
