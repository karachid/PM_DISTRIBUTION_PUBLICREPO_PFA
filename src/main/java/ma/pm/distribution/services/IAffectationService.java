package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Affectation;
import ma.pm.distribution.entities.DRAP;
import ma.pm.distribution.entities.Site;

public interface IAffectationService {
	
	public Affectation save(Affectation entity);
	
	public Affectation saveAff(Affectation entity);
	
	public Affectation update(Affectation entity);
	
	public List<Affectation> selectAll();
	
	public Affectation getById(Long id);
	
	public void remove(Long id);
	
}
