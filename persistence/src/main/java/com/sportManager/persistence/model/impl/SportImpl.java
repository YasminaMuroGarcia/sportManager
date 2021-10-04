package com.sportManager.persistence.model.impl;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sportManager.domain.api.model.Sport;

@Entity
@Table( name = "sports") 
public class SportImpl implements Sport{

	@Column( name = "name")
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private Long id;
	
	public SportImpl() {
	}
	
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
