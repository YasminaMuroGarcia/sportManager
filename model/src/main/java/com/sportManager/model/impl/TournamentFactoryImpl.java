package com.sportManager.model.impl;

import org.springframework.stereotype.Component;

import com.sportManager.model.api.Tournament;
import com.sportManager.model.api.TournamentFactory;

@Component
class TournamentFactoryImpl implements TournamentFactory {

	@Override
	public Tournament makeTournament() {
		return new TournamentImpl();
	}

}
