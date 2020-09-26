package wizen.rafal.WMP.service;

import java.util.List;

import wizen.rafal.WMP.entity.Item;

public interface BaseService {

	public <T> List<T>getAll (final Class<T> type);
	public <T> T getByID (final Class<T> type, int theId);
	public <T> void saveOrUpdate (T object);
	public <T> void delete(final Class<T> type, int theId);
	public <T> List<T> getByVariable(Class<T> type, String nameOfVariable, String value);
}
