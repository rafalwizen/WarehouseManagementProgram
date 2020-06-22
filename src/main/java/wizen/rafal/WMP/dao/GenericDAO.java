package wizen.rafal.WMP.dao;

import java.util.List;

public interface GenericDAO {

	public <T> List<T> findAll(final Class<T> type);
}
