package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IModeleDAO;
import ma.pm.distribution.entities.Modele;
import ma.pm.distribution.services.IModeleService;

@Transactional
public class ModeleServiceImpl implements IModeleService {
	
	private IModeleDAO dao;

	public void setDao(IModeleDAO dao) {
		this.dao = dao;
	}

	@Override
	public Modele save(Modele entity) {
		return dao.save(entity);
	}

	@Override
	public Modele update(Modele entity) {
		return dao.update(entity);
	}

	@Override
	public List<Modele> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Modele getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
