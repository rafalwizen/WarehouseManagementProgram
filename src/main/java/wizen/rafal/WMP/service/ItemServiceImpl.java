package wizen.rafal.WMP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.GenericDAO;
import wizen.rafal.WMP.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private GenericDAO genericDAO;
	
	@Autowired
	public ItemServiceImpl(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}



	@Override
	@Transactional
	public <T> List<T> findAll(final Class<T> type) {
		
		return genericDAO.findAll(type);
	}

}
