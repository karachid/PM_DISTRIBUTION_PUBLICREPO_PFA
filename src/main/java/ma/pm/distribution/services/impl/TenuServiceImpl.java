package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.ITenueDAO;
import ma.pm.distribution.entities.Tenue;
import ma.pm.distribution.services.ITenueService;

@Transactional
public class TenuServiceImpl implements ITenueService {
	
	private ITenueDAO dao;

	public void setDao(ITenueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Tenue save(Tenue entity) {
		return dao.save(entity);
	}

	@Override
	public Tenue update(Tenue entity) {
		return dao.update(entity);
	}

	@Override
	public List<Tenue> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Tenue getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
