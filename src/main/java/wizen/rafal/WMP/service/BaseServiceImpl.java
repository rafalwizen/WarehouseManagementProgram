package wizen.rafal.WMP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.GenericDAO;
import wizen.rafal.WMP.entity.Item;

@Service
public class BaseServiceImpl implements BaseService {

	private GenericDAO genericDAO;
	
	@Autowired
	public BaseServiceImpl(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	

	@Override
	@Transactional
	public <T> List<T> findAll(final Class<T> type) {
		return genericDAO.findAll(type);
	}

	@Override
	@Transactional
	public <T> T findByID(Class<T> type, int theId) {
		
		return genericDAO.findByID(type, theId);
	}



	@Override
	@Transactional
	public <T> void saveOrUpdate(T object) {
		genericDAO.saveOrUpdate(object);
	}

}
