package com.sportManager.application.converter.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.application.converter.SportDomainAppConverter;
import com.sportManager.model.api.Sport;
import com.sportManager.model.api.SportFactory;

@Component
class SportDomainAppConverterImpl implements SportDomainAppConverter {
	
	private	final SportFactory sportFactory;
	
	@Autowired
	public SportDomainAppConverterImpl(
			final SportFactory sportFactory) {
		this.sportFactory = sportFactory;
	}

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

	@Override
	public Sport convertAppToDomain(AppSport appSport) {
		if (appSport == null) {
			throw new IllegalArgumentException("Sport to be converted must not be null!");
		}
		final Sport sport = this.sportFactory.makeSport();
		sport.setName(appSport.getName());
		if(appSport.getId() != null) {
			sport.setId(appSport.getId());
		}
		return sport;
	}

}
