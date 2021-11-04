package com.sportManager.ui.converter;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.ui.viewModel.TournamentViewModel;

public interface TournamentAppViewModelConverter {

	TournamentViewModel convertAppToViewModel(AppTournament appTournament);
	
	AppTournament convertViewModelToApp(TournamentViewModel vmTournament);
}
