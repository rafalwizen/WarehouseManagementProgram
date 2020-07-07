package wizen.rafal.WMP.dao;

import java.util.List;

public interface GenericDAO {

	public <T> List<T> getAll(final Class<T> type);
	public <T> T getByID(final Class<T> type, int theId);
	public <T> void saveOrUpdate(T object);
	public <T> void delete(Class<T> type, int theId);
}
