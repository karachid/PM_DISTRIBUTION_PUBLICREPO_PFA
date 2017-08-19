package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Tenue;

public interface ITenueService {
	
	public Tenue save(Tenue entity);
	
	public Tenue update(Tenue entity);
	
	public List<Tenue> selectAll();
	
	public Tenue getById(Long id);
	
	public void remove(Long id);
	
}
