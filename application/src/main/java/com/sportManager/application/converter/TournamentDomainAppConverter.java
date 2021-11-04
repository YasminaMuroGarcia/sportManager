package com.sportManager.application.converter;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.model.api.Tournament;


public interface TournamentDomainAppConverter {

	Tournament convertAppToDomain(AppTournament appTournament);
}
