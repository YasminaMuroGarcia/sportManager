package com.sportManager.model.impl;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.sportManager.model.api.Sport;

@Entity
@Table( name = "sports") 
class SportImpl implements Sport{

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
	
	@Column( name = "name")
	private String name;
	
	
	public SportImpl() {
	}
	
	SportImpl(final String name, final UUID id) {
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
	public UUID getId() {
		return this.id;
	}

	@Override
	public void setId(final UUID id) {
		this.id = id;
		
	}

}
