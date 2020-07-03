package wizen.rafal.WMP.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public <T> T findByID(Class<T> type, int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		T tempObject = currentSession.get(type, theId);
		return tempObject;
	}



	@Override
	public <T> void saveOrUpdate(T object) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(object);
	}

}
