package com.sportManager.ui.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.application.api.service.SportService;
import com.sportManager.ui.URLContract;
import com.sportManager.ui.converter.SportAppViewModelConverter;
import com.sportManager.ui.viewModel.SportViewModel;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
public class SportController {
	
	private final SportService sportService;
	private final SportAppViewModelConverter sportConverter;
	
	@Autowired
	public SportController(
			final SportService sportService,
			final SportAppViewModelConverter sportConverter) {
		this.sportService = sportService;
		this.sportConverter = sportConverter;
	}

	@GetMapping(URLContract.SPORT_LIST_ALL_URL)
	@ResponseBody
	public Collection<SportViewModel> getAllSports() {
		final Collection<AppSport> appSports = this.sportService.getAllSports();
		return this.sportConverter.convertAppsToViewModels(appSports);
	}
	
	@PostMapping(URLContract.CREATE_SPORT_URL)
	@ResponseBody
	public SportViewModel addSport(@RequestBody final SportViewModel vMSport) {
		final AppSport appSport = this.sportConverter.convertViewModelToApp(vMSport);
		final AppSport createdSport =  this.sportService.createSport(appSport);
		return this.sportConverter.convertAppToViewModel(createdSport);
	}
}
