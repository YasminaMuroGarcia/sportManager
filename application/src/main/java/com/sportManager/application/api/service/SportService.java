package com.sportManager.application.api.service;

import java.util.Collection;

import com.sportManager.application.api.model.AppSport;

public interface SportService {

	Collection<AppSport> getAllSports();
	
	void createSport(AppSport appSport);
	
}
