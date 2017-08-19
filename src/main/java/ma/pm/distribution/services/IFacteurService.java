package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Facteur;

public interface IFacteurService {
	
	public Facteur save(Facteur entity);
	
	public Facteur update(Facteur entity);
	
	public List<Facteur> selectAll();
	
	public Facteur getById(Long id);
	
	public void remove(Long id);
	
}
