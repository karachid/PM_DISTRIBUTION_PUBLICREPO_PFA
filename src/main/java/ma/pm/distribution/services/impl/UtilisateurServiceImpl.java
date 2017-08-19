package ma.pm.distribution.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ma.pm.distribution.dao.IUtilisateurDAO;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.IUtilisateurService;

@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	private IUtilisateurDAO dao;
	
	public void setDao(IUtilisateurDAO dao) {
		this.dao = dao;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		return dao.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Utilisateur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}
	
}
