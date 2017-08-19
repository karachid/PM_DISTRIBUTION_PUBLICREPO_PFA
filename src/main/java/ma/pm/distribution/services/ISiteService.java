package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Site;

public interface ISiteService {
	
	public Site save(Site entity);
	
	public Site update(Site entity);
	
	public List<Site> selectAll();
	
	public Site getById(Long id);
	
	public void remove(Long id);
	
}
