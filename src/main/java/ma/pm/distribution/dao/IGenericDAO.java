package ma.pm.distribution.dao;

import java.util.List;

public interface IGenericDAO<E> {
	
	public E save(E entity);
	public E update(E entity);
	public List<E> selectAll();
	public E getById(Long id);
	public E findOne(String paramName, String paramValue);
	public void remove(Long id);
	
}
