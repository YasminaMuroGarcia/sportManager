package com.sportManager.persistence.model.factory.impl;

import org.springframework.stereotype.Component;

import com.sportManager.domain.api.model.Sport;
import com.sportManager.domain.api.model.factory.SportFactory;
import com.sportManager.persistence.model.impl.SportImpl;
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
