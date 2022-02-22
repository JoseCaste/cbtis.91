package com.cbtis91.interfaces;

import java.util.List;

public interface IDAOcrud<T> {

	public boolean save(T data);
	public List<T> getAll();
	public T getByName(String name);
}
