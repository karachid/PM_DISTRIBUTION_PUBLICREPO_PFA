package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Secteur;
import ma.pm.distribution.entities.Site;

public interface ISecteurService {
	
	public Secteur save(Secteur entity);
	
	public Secteur update(Secteur entity);
	
	public List<Secteur> selectAll();
	
	public Secteur getById(Long id);
	
	public void remove(Long id);
	
	public Secteur findOne(String paramName, String paramValue);
	
}
