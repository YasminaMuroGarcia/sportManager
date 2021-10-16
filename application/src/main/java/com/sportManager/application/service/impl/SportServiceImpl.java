package com.sportManager.application.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.application.api.service.SportService;
import com.sportManager.application.converter.SportDomainAppConverter;
import com.sportManager.model.api.Sport;
import com.sportManager.model.api.repository.SportRepository;

@Component
class SportServiceImpl implements SportService {
	
	private final SportRepository sportDao;
	private final SportDomainAppConverter sportConverter;

	@Autowired
	public SportServiceImpl(
			final SportRepository sportDao,
			final SportDomainAppConverter sportConverter) {
		this.sportDao = sportDao;
		this.sportConverter = sportConverter;
	}
	
	@Override
	public Collection<AppSport> getAllSports() {
		List<Sport> sports = (List<Sport>) this.sportDao.getAllSports();
		return this.sportConverter.convertDomainsToApps(sports);
	}

	@Override
	public AppSport createSport(final AppSport appSport) {
		final Sport sport = this.sportConverter.convertAppToDomain(appSport);
		final Long id = this.sportDao.addSport(sport);
		appSport.setId(id);
		return appSport;
	}

}
