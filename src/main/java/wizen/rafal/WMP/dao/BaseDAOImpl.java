package wizen.rafal.WMP.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class BaseDAOImpl implements BaseDAO {

	protected EntityManager entityManager;
	
	@Override
	public List findAll(Class aClass) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query <Class>theQuery = currentSession.createQuery("from "+aClass.getSimpleName(), Class.class);
		List<Class> items = theQuery.getResultList();
		
		return items;
	}

}
