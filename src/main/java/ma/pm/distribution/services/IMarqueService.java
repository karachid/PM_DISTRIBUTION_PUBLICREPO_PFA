package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Marque;

public interface IMarqueService {
	
	public Marque save(Marque entity);
	
	public Marque update(Marque entity);
	
	public List<Marque> selectAll();
	
	public Marque getById(Long id);
	
	public void remove(Long id);
	
}
