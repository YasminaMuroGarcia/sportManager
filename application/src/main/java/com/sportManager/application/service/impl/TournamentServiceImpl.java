package com.sportManager.application.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.application.api.service.TournamentService;
import com.sportManager.application.converter.TournamentDomainAppConverter;
import com.sportManager.model.api.Tournament;
import com.sportManager.model.api.repository.TournamentRepository;

@Component
class TournamentServiceImpl implements TournamentService {

	private final TournamentRepository tournamentRepo;
	private final TournamentDomainAppConverter tournamentConverter;
	
	@Autowired
	public TournamentServiceImpl(
			final TournamentRepository tournamentRepo,
			final TournamentDomainAppConverter tournamentConverter) {
		this.tournamentRepo = tournamentRepo;
		this.tournamentConverter = tournamentConverter;
		
	}
	
	@Override
	public AppTournament createTournament(final AppTournament appTournament) {
		final Tournament tournament = this.tournamentConverter.convertAppToDomain(appTournament);
		final UUID id = this.tournamentRepo.addTournament(tournament);
		appTournament.setId(id);
		return appTournament;
	}

}
