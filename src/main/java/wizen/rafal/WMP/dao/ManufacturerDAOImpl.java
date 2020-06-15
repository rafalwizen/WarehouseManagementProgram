package wizen.rafal.WMP.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wizen.rafal.WMP.entity.Manufacturer;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{

	private EntityManager entityManager;
	
	@Autowired
	public ManufacturerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Manufacturer> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query <Manufacturer>theQuery = currentSession.createQuery("from Manufacturer", Manufacturer.class);
		List<Manufacturer>manufacturers = theQuery.getResultList();
		return manufacturers;
	}

}
