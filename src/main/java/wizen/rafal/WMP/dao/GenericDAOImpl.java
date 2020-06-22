package wizen.rafal.WMP.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wizen.rafal.WMP.entity.Item;

@Repository
public class GenericDAOImpl implements GenericDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public GenericDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	public <T> List<T> findAll(final Class<T> type) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query <T>theQuery = currentSession.createQuery("from "+ type.getSimpleName(), type);
		List<T> list = theQuery.getResultList();
		
		return list;
	}

}
