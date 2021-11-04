package com.sportManager.model.impl;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.sportManager.model.api.Tournament;

@Entity
@Table( name = "tournaments") 
class TournamentImpl implements Tournament {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
	private UUID id;
	
	@Column( name = "name")
	private String name;
	
	@Column(name = "gameReference", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
	private UUID gameReference;
	
	@Column( name = "contestantType")
	private String contestantType;
	
	@Column( name = "numberPlayers")
	private Integer numberPlayers;
	
	@Override
	public UUID getId() {
		return this.id;
	}

	@Override
	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public UUID getGameReference() {
		return this.gameReference;
	}

	@Override
	public void setGameReference(UUID gameReference) {
		this.gameReference = gameReference;
	}

	@Override
	public String getContestantType() {
		return this.contestantType;
	}

	@Override
	public void setContestantType(String contestantType) {
		this.contestantType = contestantType;
	}

	@Override
	public Integer getNumberPlayers() {
		return this.numberPlayers;
	}

	@Override
	public void setNumberPlayers(Integer numberPlayers) {
		this.numberPlayers= numberPlayers;
	}

}
