package ma.pm.distribution.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IGenericDAO<E> {
	
	public E save(E entity);
	public E saveAff(E entity);
	public E update(E entity);
	public List<E> selectAll();
	public E getById(Long id);
	public E findOne(String paramName, String paramValue);
	public List<E> findByAttribute(String paramName, boolean paramValue, String paramName2, String paramValue2); 
	public void remove(Long id);
	public boolean isExist(List<Object> paramNameList , List<Object>  paramValueList);
	
}
