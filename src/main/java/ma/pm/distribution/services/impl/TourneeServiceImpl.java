package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.ITourneeDAO;
import ma.pm.distribution.entities.Tournee;
import ma.pm.distribution.services.ITourneeService;

@Transactional
public class TourneeServiceImpl implements ITourneeService {
	
	private ITourneeDAO dao;
	
	public void setDao(ITourneeDAO dao) {
		this.dao = dao;
	}

	@Override
	public Tournee save(Tournee entity) {
		return dao.save(entity);
	}

	@Override
	public Tournee update(Tournee entity) {
		return dao.update(entity);
	}

	@Override
	public List<Tournee> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Tournee getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	
	@Override
	public List<Tournee> findByAttribute(String paramName1, boolean paramValue1, String paramName2, String paramValue2) {
		return dao.findByAttribute(paramName1, paramValue1, paramName2, paramValue2);
	}
	

}
