package com.sportManager.ui.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.application.api.service.SportService;
import com.sportManager.ui.URLContract;
import com.sportManager.ui.converter.SportAppViewModelConverter;
import com.sportManager.ui.viewModel.SportViewModel;

@Controller
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
}
