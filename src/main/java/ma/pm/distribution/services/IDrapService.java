package ma.pm.distribution.services;

import java.util.List;


import ma.pm.distribution.entities.DRAP;

public interface IDrapService {
	
	public DRAP save(DRAP entity);
	
	public DRAP update(DRAP entity);
	
	public List<DRAP> selectAll();
	
	public DRAP getById(Long id);
	
	public DRAP getByName(String drapName);
	
	public DRAP findOne(String paramName, String paramValue);
	
	public void remove(Long id);
	
}
