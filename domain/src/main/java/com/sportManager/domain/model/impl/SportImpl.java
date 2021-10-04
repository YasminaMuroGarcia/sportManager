package com.sportManager.domain.model.impl;

import com.sportManager.domain.api.model.Sport;

class SportImpl implements Sport{

	private String name;
	private Long id;
	
	 SportImpl(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
		
	}

}
