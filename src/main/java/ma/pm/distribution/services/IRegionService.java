package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Region;

public interface IRegionService {
	
	public Region save(Region entity);
	
	public Region update(Region entity);
	
	public List<Region> selectAll();
	
	public Region getById(Long id);
	
	public void remove(Long id);
	
}

