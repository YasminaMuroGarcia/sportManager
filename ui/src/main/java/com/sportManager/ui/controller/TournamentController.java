package com.sportManager.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportManager.application.api.model.AppTournament;
import com.sportManager.application.api.service.TournamentService;
import com.sportManager.ui.URLContract;
import com.sportManager.ui.converter.TournamentAppViewModelConverter;
import com.sportManager.ui.viewModel.TournamentViewModel;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
public class TournamentController {
	
	private final TournamentService tournamentService;
	private final TournamentAppViewModelConverter tournamentConverter;
	@Autowired
	public TournamentController(
			final TournamentService tournamentService,
			final TournamentAppViewModelConverter tournamentConverter) {
		this.tournamentService = tournamentService;
		this.tournamentConverter = tournamentConverter;
	}
	
	@PostMapping(URLContract.CREATE_TOURNAMENT_URL)
	@ResponseBody
	public TournamentViewModel addTournament(@RequestBody final TournamentViewModel vmTorunament) {
		final AppTournament appTournament= this.tournamentConverter.convertViewModelToApp(vmTorunament);
		final AppTournament createdTournament =  this.tournamentService.createTournament(appTournament);
		return this.tournamentConverter.convertAppToViewModel(createdTournament);
	}
	
}
