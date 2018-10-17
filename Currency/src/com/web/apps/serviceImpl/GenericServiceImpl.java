package com.web.apps.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.web.apps.service.GenericService;

@Transactional(propagation = Propagation.REQUIRED)
public class GenericServiceImpl<T> implements GenericService<T> {
	
	private Logger logger = Logger.getLogger(GenericServiceImpl.class);
	
	@PersistenceContext(unitName="currency")
	protected EntityManager entityManager;
	private Class<T> type;

	@Override
	public T find(Object id) {
		return null;
	}

	@Override
	public T save(final T t) {		
		Session session = entityManager.unwrap(Session.class);
		logger.info("saving "+t+" instance");
		try {
			session.persist(t);
			logger.info(t+" saved successful");
			session.flush();
			session.clear();
			return t;
			
		} catch (RuntimeException re) {
			logger.info("saving "+t+" failed", re);
			throw re;
		}
	}
}
