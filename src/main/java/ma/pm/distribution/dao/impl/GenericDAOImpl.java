package ma.pm.distribution.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.pm.distribution.dao.IGenericDAO;

public class GenericDAOImpl<E> implements IGenericDAO<E> {

	@PersistenceContext
	EntityManager em;
	
	private Class<E> type;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		return em.merge(entity);
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("select t from " + type.getSimpleName() +  " t");
		return query.getResultList();
	}

	@Override
	public E getById(Long id) {
		return em.find(type, id);
	}
	
	@Override
	public E findOne(String paramName, String paramValue) {
		System.out.println(type.getSimpleName());
		System.out.println(paramName + " = " + paramValue);
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where t." + paramName + " like '"+paramValue+"'");
		//query.setParameter("x", paramValue);
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public void remove(Long id) {
		E tab  = em.getReference(type, id);
		em.remove(tab);
	}

}
