package wizen.rafal.WMP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.GenericDAO;

@Service
@Primary
public class BaseServiceImpl implements BaseService {

	protected GenericDAO genericDAO;
	
	@Autowired
	public BaseServiceImpl(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	

	@Override
	@Transactional
	public <T> List<T> getAll(final Class<T> type) {
		return genericDAO.getAll(type);
	}

	@Override
	@Transactional
	public <T> T getByID(Class<T> type, int theId) {
		
		return genericDAO.getByID(type, theId);
	}



	@Override
	@Transactional
	public <T> void saveOrUpdate(T object) {
		genericDAO.saveOrUpdate(object);
	}



	@Override
	@Transactional
	public <T> void delete(Class<T> type, int theId) {
		genericDAO.delete(type, theId);		
	}

}
