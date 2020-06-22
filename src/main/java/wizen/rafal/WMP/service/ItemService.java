package wizen.rafal.WMP.service;

import java.util.List;

import wizen.rafal.WMP.entity.Item;

public interface ItemService {

	public <T> List<T>findAll(final Class<T> type);
}
