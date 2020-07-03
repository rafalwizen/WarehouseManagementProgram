package wizen.rafal.WMP.service;

import java.util.List;

import wizen.rafal.WMP.entity.Item;

public interface BaseService {

	public <T> List<T>findAll(final Class<T> type);
	public <T> T findByID (final Class<T> type, int theId);
}
