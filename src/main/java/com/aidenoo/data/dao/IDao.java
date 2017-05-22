package com.aidenoo.data.dao;

import java.util.List;

public interface IDao<T> {
	public boolean create(T t);
	public T search(String name);
	public boolean update(T t);
	public boolean delete(T t);
	public List<T> read();
}
