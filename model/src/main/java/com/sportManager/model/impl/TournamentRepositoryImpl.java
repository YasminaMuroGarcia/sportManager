package com.sportManager.model.impl;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sportManager.model.api.Tournament;
import com.sportManager.model.api.repository.TournamentRepository;

@Repository
class TournamentRepositoryImpl implements TournamentRepository {

	private final SessionFactory sessionFactory;
	
	@Autowired
	public TournamentRepositoryImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public UUID addTournament(Tournament tournament) {
		final Session session = this.sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		UUID id = (UUID) session.save((TournamentImpl) tournament);
		tx.commit();
		session.close();
		return id;
	}

}
