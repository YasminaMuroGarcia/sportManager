package com.sportManager.model.impl;

import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sportManager.model.api.Sport;
import com.sportManager.model.api.repository.SportRepository;

@Repository
class SportRepositoryImpl implements SportRepository{
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public SportRepositoryImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<? extends Sport> getAllSports() {
		final Session session = this.sessionFactory.openSession();
		final CriteriaBuilder builder = session.getCriteriaBuilder();
		final CriteriaQuery<SportImpl> criteria = builder.createQuery(SportImpl.class);
		criteria.from(SportImpl.class);
		List<SportImpl> sports = session.createQuery(criteria).getResultList();
		session.close();
		return sports;
	}

	@Override
	@Transactional
	public UUID addSport(Sport sport) {
		final Session session = this.sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		UUID id = (UUID) session.save((SportImpl) sport);
		tx.commit();
		session.close();
		return id;
	}
	

}
