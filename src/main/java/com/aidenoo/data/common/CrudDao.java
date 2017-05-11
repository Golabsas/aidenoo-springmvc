package com.aidenoo.data.common;

public interface CrudDao<T> {
	public boolean create(T t);
	public T read(String name);
	public boolean update(T t);
	public boolean delete(T t);
}
