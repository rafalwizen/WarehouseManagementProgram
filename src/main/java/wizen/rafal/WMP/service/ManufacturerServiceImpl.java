package wizen.rafal.WMP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.ManufacturerDAO;
import wizen.rafal.WMP.entity.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private ManufacturerDAO manufacturerDAO;
	
	@Autowired
	public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
		this.manufacturerDAO = manufacturerDAO;
	}

	@Override
	@Transactional
	public List<Manufacturer> findAll() {
		return manufacturerDAO.findAll();
	}

}
