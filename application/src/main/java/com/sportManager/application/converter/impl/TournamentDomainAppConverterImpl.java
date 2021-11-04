package com.sportManager.application.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.application.converter.TournamentDomainAppConverter;
import com.sportManager.model.api.Tournament;
import com.sportManager.model.api.TournamentFactory;

@Component
class TournamentDomainAppConverterImpl implements TournamentDomainAppConverter {

	private	final TournamentFactory tournamentFactory;
	
	@Autowired
	public TournamentDomainAppConverterImpl(
			final TournamentFactory tournamentFactory) {
		this.tournamentFactory = tournamentFactory;
	}
	
	@Override
	public Tournament convertAppToDomain(AppTournament appTournament) {
		if (appTournament == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final Tournament tournament = this.tournamentFactory.makeTournament();
		tournament.setName(appTournament.getName());
		if(appTournament.getId() != null) {
			tournament.setId(appTournament.getId());
		}
		tournament.setContestantType(appTournament.getContestantType());
		tournament.setGameReference(appTournament.getGameReference());
		tournament.setNumberPlayers(appTournament.getNumberPlayers());
		return tournament;
	}

}
