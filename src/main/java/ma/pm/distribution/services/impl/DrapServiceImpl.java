package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IDrapDAO;
import ma.pm.distribution.entities.DRAP;
import ma.pm.distribution.services.IDrapService;

@Transactional
public class DrapServiceImpl implements IDrapService {
	
	private IDrapDAO dao;
	
	public void setDao(IDrapDAO dao) {
		this.dao = dao;
	}

	@Override
	public DRAP save(DRAP entity) {
		return dao.save(entity);
	}

	@Override
	public DRAP update(DRAP entity) {
		return dao.update(entity);
	}

	@Override
	public List<DRAP> selectAll() {
		return dao.selectAll();
	}

	@Override
	public DRAP getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public DRAP getByName(String drapName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DRAP findOne(String paramName, String paramValue) {
		return dao.findOne(paramName, paramValue);
	}

}
