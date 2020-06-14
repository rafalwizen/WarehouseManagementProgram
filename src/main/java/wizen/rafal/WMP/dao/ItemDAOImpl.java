package wizen.rafal.WMP.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wizen.rafal.WMP.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public ItemDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	public List<Item> findAll() {
		return null;
	}

}
