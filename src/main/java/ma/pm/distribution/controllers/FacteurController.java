package ma.pm.distribution.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.pm.distribution.entities.Facteur;
import ma.pm.distribution.services.IFacteurService;

@Controller
@RequestMapping(value="/facteur")
public class FacteurController {
	
	@Autowired
	private IFacteurService facteurService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String facteur(Model model) {
		List<Facteur> facteurs = facteurService.selectAll();
		//List<Facteur> facteurs= new ArrayList<Facteur>();
		if (facteurs == null) {
			facteurs = new ArrayList<Facteur>();
		}
		model.addAttribute("facteurs", facteurs);
		System.out.println("FacteurController : facteur() method ... ");
		return "facteur/facteur";
	}
	
	@RequestMapping(value = "/ajoutfacteur/", method = RequestMethod.GET)
	public String ajouterArticle() {
		return "facteur/ajoutfacteur";
	}
	
}
