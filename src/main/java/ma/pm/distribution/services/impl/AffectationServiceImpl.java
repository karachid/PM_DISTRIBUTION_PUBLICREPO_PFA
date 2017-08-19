package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IAffectationDAO;
import ma.pm.distribution.entities.Affectation;
import ma.pm.distribution.services.IAffectationService;

@Transactional
public class AffectationServiceImpl implements IAffectationService {
	
	private IAffectationDAO dao;

	public void setDao(IAffectationDAO dao) {
		this.dao = dao;
	}

	@Override
	public Affectation save(Affectation entity) {
		return dao.save(entity);
	}

	@Override
	public Affectation update(Affectation entity) {
		return dao.update(entity);
	}

	@Override
	public List<Affectation> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Affectation getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
