package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.ISecteurDAO;
import ma.pm.distribution.entities.Secteur;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.services.ISecteurService;

@Transactional
public class SecteurServiceImpl implements ISecteurService {

	private ISecteurDAO dao;
	
	public void setDao(ISecteurDAO dao) {
		this.dao = dao;
	}

	@Override
	public Secteur save(Secteur entity) {
		return dao.save(entity);
	}

	@Override
	public Secteur update(Secteur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Secteur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Secteur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Secteur findOne(String paramName, String paramValue) {
		return dao.findOne(paramName, paramValue);
	}

}
