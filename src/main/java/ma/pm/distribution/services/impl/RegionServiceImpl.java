package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IRegionDAO;
import ma.pm.distribution.entities.Region;
import ma.pm.distribution.services.IRegionService;

@Transactional
public class RegionServiceImpl implements IRegionService {

	private IRegionDAO dao;
	
	public void setDao(IRegionDAO dao) {
		this.dao = dao;
	}

	@Override
	public Region save(Region entity) {
		return dao.save(entity);
	}

	@Override
	public Region update(Region entity) {
		return dao.update(entity);
	}

	@Override
	public List<Region> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Region getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
