package com.sportManager.ui.converter;

import java.util.Collection;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.ui.viewModel.SportViewModel;

public interface SportAppViewModelConverter {
	
	SportViewModel convertAppToViewModel(AppSport appSport);

	Collection<SportViewModel> convertAppsToViewModels(Collection<AppSport> appSports);
	
	AppSport convertViewModelToApp(SportViewModel vMSport);
}
