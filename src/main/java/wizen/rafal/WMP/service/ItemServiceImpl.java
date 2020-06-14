package wizen.rafal.WMP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.ItemDAO;
import wizen.rafal.WMP.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemDAO itemDAO;
	
	@Autowired
	public ItemServiceImpl(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}



	@Override
	@Transactional
	public List<Item> findAll() {
		
		
		return null;
	}

}
