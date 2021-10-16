package com.sportManager.model.api.repository;

import java.util.List;

import com.sportManager.model.api.Sport;

public interface SportRepository{
	
	List<? extends Sport> getAllSports();
	
	 Long addSport(Sport sport);

}
