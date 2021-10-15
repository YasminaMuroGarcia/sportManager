package com.sportManager.domain.api.repository;

import java.util.List;

import com.sportManager.domain.api.model.Sport;

public interface SportRepository{
	
	List<? extends Sport> getAllSports();
	
	 Long addSport(Sport sport);

}
