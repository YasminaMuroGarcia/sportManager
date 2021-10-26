package com.sportManager.ui.converter.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.ui.converter.SportAppViewModelConverter;
import com.sportManager.ui.viewModel.SportViewModel;

@Component
class SportAppViewModelConverterImpl implements SportAppViewModelConverter {

	@Override
	public SportViewModel convertAppToViewModel(final AppSport appSport) {
		if (appSport == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final SportViewModel vmSport = new SportViewModel();
		vmSport.setId((appSport.getId().toString()));
		vmSport.setName(appSport.getName());
		return vmSport;
	}

	@Override
	public Collection<SportViewModel> convertAppsToViewModels(final Collection<AppSport> appSports) {
		if (appSports == null) {
			throw new IllegalArgumentException("List of Sports to be converted must not be null!");
		}
		Collection<SportViewModel> sportsVms = new ArrayList<SportViewModel>();
		for(final AppSport appSport : appSports) {
			sportsVms.add(this.convertAppToViewModel(appSport));
		}
		return sportsVms;
	}

	@Override
	public AppSport convertViewModelToApp(SportViewModel vMSport) {
		if(vMSport == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final AppSport appSport = new AppSport();
		try{
			appSport.setId(UUID.fromString(vMSport.getId()));
		}catch (Exception e) {
		}
		appSport.setName(vMSport.getName());
		return appSport;
	}

}
