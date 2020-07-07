package wizen.rafal.WMP.dao;

import java.util.List;

public interface GenericDAO {

	public <T> List<T> findAll(final Class<T> type);
	public <T> T findByID(final Class<T> type, int theId);
	public <T> void saveOrUpdate(T object);
	public <T> void delete(Class<T> type, int theId);
}
