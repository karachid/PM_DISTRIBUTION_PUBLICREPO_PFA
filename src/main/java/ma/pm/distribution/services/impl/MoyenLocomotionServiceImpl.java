package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IMoyenLocomotionDAO;
import ma.pm.distribution.entities.MoyenLocomotion;
import ma.pm.distribution.services.IMoyenLocomotionService;

@Transactional
public class MoyenLocomotionServiceImpl implements IMoyenLocomotionService {
	
	private IMoyenLocomotionDAO dao;

	public void setDao(IMoyenLocomotionDAO dao) {
		this.dao = dao;
	}

	@Override
	public MoyenLocomotion save(MoyenLocomotion entity) {
		return dao.save(entity);
	}

	@Override
	public MoyenLocomotion update(MoyenLocomotion entity) {
		return dao.update(entity);
	}

	@Override
	public List<MoyenLocomotion> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MoyenLocomotion getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

}
