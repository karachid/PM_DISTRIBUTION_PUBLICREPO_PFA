package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IFacteurDAO;
import ma.pm.distribution.entities.Facteur;
import ma.pm.distribution.services.IFacteurService;

@Transactional
public class FacteurServiceImpl implements IFacteurService {
	
	private IFacteurDAO dao;

	public void setDao(IFacteurDAO dao) {
		this.dao = dao;
	}

	@Override
	public Facteur save(Facteur entity) {
		return dao.save(entity);
	}

	@Override
	public Facteur update(Facteur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Facteur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Facteur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.getById(id);
	}

}
