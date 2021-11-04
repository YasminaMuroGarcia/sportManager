package com.sportManager.model.api.repository;

import java.util.UUID;

import com.sportManager.model.api.Sport;
import com.sportManager.model.api.Tournament;

public interface TournamentRepository {

	 UUID addTournament(Tournament tournament);
}
