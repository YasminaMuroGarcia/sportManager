package com.sportManager.application.converter.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.application.converter.SportDomainAppConverter;
import com.sportManager.domain.api.model.Sport;

@Component
class SportDomainAppConverterImpl implements SportDomainAppConverter {

	@Override
	public AppSport convertDomainToApp(final Sport sport) {
		if (sport == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final AppSport appSport = new AppSport();
		appSport.setId(sport.getId());
		appSport.setName(sport.getName());
		return appSport;
	}

	@Override
	public Collection<AppSport> convertDomainsToApps(final Collection<Sport> sports) {
		if (sports == null) {
			throw new IllegalArgumentException("List of Sports to be converted must not be null!");
		}
		Collection<AppSport> appSports = new ArrayList<AppSport>();
		for(final Sport sport: sports) {
			appSports.add(this.convertDomainToApp(sport));
		}
		return appSports;
	}

}
