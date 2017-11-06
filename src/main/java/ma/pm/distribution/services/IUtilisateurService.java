package ma.pm.distribution.services;

import java.util.List;

import ma.pm.distribution.entities.Utilisateur;

public interface IUtilisateurService {
	
	public Utilisateur save(Utilisateur entity);
	
	public Utilisateur update(Utilisateur entity);
	
	public List<Utilisateur> selectAll();
	
	public Utilisateur getById(Long id);
	
	public void remove(Long id);
	
	public boolean isExist(List<Object> paramNameList , List<Object>  paramValueList);
	
}
