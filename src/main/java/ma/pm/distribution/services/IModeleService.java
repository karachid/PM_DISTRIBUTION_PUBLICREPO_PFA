package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Modele;

public interface IModeleService {
	
	public Modele save(Modele entity);
	
	public Modele update(Modele entity);
	
	public List<Modele> selectAll();
	
	public Modele getById(Long id);
	
	public void remove(Long id);
	
}
