package br.edu.infnet.brunanunesapi.interfaces;

import java.util.List;

public interface CrudService<T, ID> {

	T create(T entity);
	List<T> getAll();
	T update(ID id, T entity);
	void delete(ID id);
}
