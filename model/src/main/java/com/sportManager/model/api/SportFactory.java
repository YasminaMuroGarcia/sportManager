package com.sportManager.model.api;

public interface SportFactory {
	Sport makeSport();
	
	Sport makeSport(String name);
}
