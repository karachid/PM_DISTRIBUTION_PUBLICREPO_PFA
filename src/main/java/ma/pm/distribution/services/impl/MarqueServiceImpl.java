package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IMarqueDAO;
import ma.pm.distribution.entities.Marque;
import ma.pm.distribution.services.IMarqueService;

@Transactional
public class MarqueServiceImpl implements IMarqueService {
	
	private IMarqueDAO dao;

	public void setDao(IMarqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Marque save(Marque entity) {
		return dao.save(entity);
	}

	@Override
	public Marque update(Marque entity) {
		return dao.update(entity);
	}

	@Override
	public List<Marque> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Marque getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
