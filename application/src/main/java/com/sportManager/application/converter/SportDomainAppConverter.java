package com.sportManager.application.converter;

import java.util.Collection;

import com.sportManager.application.api.model.AppSport;
import com.sportManager.domain.api.model.Sport;

public interface SportDomainAppConverter {
	
	AppSport convertDomainToApp(Sport sport);
	
	Collection<AppSport> convertDomainsToApps(Collection<Sport> sports);

}
