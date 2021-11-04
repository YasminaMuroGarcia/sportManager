package com.sportManager.ui.converter.impl;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.ui.viewModel.TournamentViewModel;

@Component
class TournamentAppViewModelConverter implements com.sportManager.ui.converter.TournamentAppViewModelConverter {

	@Override
	public TournamentViewModel convertAppToViewModel(final AppTournament appTournament) {
		if(appTournament == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final TournamentViewModel vmTournament = new TournamentViewModel();
		vmTournament.setId(appTournament.getId().toString());
		vmTournament.setName(appTournament.getName());
		vmTournament.setContestantType(appTournament.getContestantType());
		vmTournament.setGameId(appTournament.getGameReference().toString());
		vmTournament.setNumberPlayers(appTournament.getNumberPlayers().toString());
		return vmTournament;
	}

	@Override
	public AppTournament convertViewModelToApp(final TournamentViewModel vmTournament) {
		
		if(vmTournament == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final AppTournament appTournament = new AppTournament();
		
		try {
			appTournament.setId(UUID.fromString(vmTournament.getId()));
		}catch (Exception e) {
		}
		try {
			appTournament.setGameReference(UUID.fromString(vmTournament.getGameId()));
		}catch (Exception e) {
		}
		try {
			appTournament.setNumberPlayers(Integer.valueOf(vmTournament.getNumberPlayers()));
		}catch (Exception e) {
		}
		appTournament.setName(vmTournament.getName());
		appTournament.setContestantType(vmTournament.getContestantType());
		return appTournament;
	}

}
