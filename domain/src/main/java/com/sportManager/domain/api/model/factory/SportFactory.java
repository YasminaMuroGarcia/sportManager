package com.sportManager.domain.api.model.factory;

import com.sportManager.domain.api.model.Sport;


public interface SportFactory {
	Sport makeSport();
	
	Sport makeSport(String name);
}
