package com.sportManager.model.impl;

import org.springframework.stereotype.Component;

import com.sportManager.model.api.Sport;
import com.sportManager.model.api.SportFactory;
@Component
class SportFactoryImpl implements SportFactory {

	@Override
	public Sport makeSport() {
		return new SportImpl();
	}

	@Override
	public Sport makeSport(String name) {
		final Sport sport = new SportImpl();
		sport.setName(name);
		return sport;
	}

}
