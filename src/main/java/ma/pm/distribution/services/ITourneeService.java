package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Affectation;
import ma.pm.distribution.entities.Tournee;

public interface ITourneeService {
	
	public Tournee save(Tournee entity);
	
	public Tournee update(Tournee entity);
	
	public List<Tournee> selectAll();
	
	public Tournee getById(Long id);
	
	public void remove(Long id);
	
	public List<Tournee> findByAttribute(String paramName, boolean paramValue, String paramName2, String paramValue2);
	
}
