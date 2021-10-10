package com.sportManager.persistence.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sportManager.domain.api.model.Sport;
import com.sportManager.domain.api.repository.SportRepository;
import com.sportManager.persistence.model.impl.SportImpl;

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
	public void addSport(Sport sport) {
		final Session session = this.sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		session.save((SportImpl) sport);
		tx.commit();
		session.close();
	}

}
