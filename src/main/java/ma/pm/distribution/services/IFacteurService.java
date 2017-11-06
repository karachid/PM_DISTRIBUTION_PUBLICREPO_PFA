package ma.pm.distribution.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ma.pm.distribution.entities.Facteur;

public interface IFacteurService {
	
	public Facteur save(Facteur entity);
	
	public Facteur update(Facteur entity);
	
	public List<Facteur> selectAll();
	
	public Facteur getById(Long id);
	
	public void remove(Long id);
	
	public List<Facteur> facteurImportXls(MultipartFile file) throws Exception;
	
	public List<Facteur> facteurImportXlsx(MultipartFile file) throws Exception;
	
}
