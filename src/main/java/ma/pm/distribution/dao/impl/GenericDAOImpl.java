package ma.pm.distribution.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

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
		//System.out.println(type.getSimpleName());
		//System.out.println(paramName + " = " + paramValue);
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where t." + paramName + " like '%"+paramValue+"%'");
		//query.setParameter("x", paramValue);
		//System.out.println("SIZE OF RETURNED RESULT : " + query.getResultList().size());
		//System.out.println("Returned OBJECT : " + query.getResultList().get(0).toString());
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public void remove(Long id) {
		E tab  = em.getReference(type, id);
		em.remove(tab);
		System.out.println("Suppression => " + type + " = " + id);
	}

	@Override
	public boolean isExist(List<Object> paramNameList, List<Object> paramValueList) {
		StringBuilder st = new StringBuilder();
		st.append("select t from " + type.getSimpleName() + " t where ");
		for(int i=0;i<paramNameList.size();i++) {
			if(i!=0)
			st.append(" and t."+paramNameList.get(i)+" like '" + paramValueList.get(i)+"'");
			else st.append(" t."+paramNameList.get(i)+" like '" + paramValueList.get(i)+"'");
		}
		Query query = em.createQuery(st.toString());
		if(query.getResultList().size()==1) {
			return true;
		}
		return false;
	}

	@Override
	public List<E> findByAttribute(String paramName1, boolean paramValue1, String paramName2, String paramValue2) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where t." + paramName1 + " = " + paramValue1 + " and t.secteur.site." + paramName2 + " like '%"+paramValue2+"%'");
		return query.getResultList();
	}

	@Override
	public E saveAff(E entity) {
		em.merge(entity);
		return entity;
	}

}
