package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.ISiteDAO;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.services.ISiteService;

@Transactional
public class SiteServiceImpl implements ISiteService {

	private ISiteDAO dao;
	
	public void setDao(ISiteDAO dao) {
		this.dao = dao;
	}

	@Override
	public Site save(Site entity) {
		return dao.save(entity);
	}

	@Override
	public Site update(Site entity) {
		return dao.update(entity);
	}

	@Override
	public List<Site> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Site getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Site findOne(String paramName, String paramValue) {
		return dao.findOne(paramName, paramValue);
	}

}
