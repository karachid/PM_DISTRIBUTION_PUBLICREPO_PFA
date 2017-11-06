package ma.pm.distribution.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.pm.distribution.entities.Secteur;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.entities.Tournee;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.ISecteurService;
import ma.pm.distribution.services.ISiteService;
import ma.pm.distribution.services.ITourneeService;
import ma.pm.distribution.xlsview.TourneeExcelReportView;

@Controller
@RequestMapping(value="/tournee")
public class TourneeController {
	
	@Autowired
	private ISecteurService secteurService;
	
	@Autowired
	private ISiteService siteService;
	
	@Autowired
	private ITourneeService tourneeService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value="/")
	public String tournee(Model model, HttpServletRequest request) {
		List<Tournee> tournees = new ArrayList<>();
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		for(int i=0;i<site.getSecteurs().size();i++) {
			tournees.addAll(site.getSecteurs().get(i).getTournees());
		}
		model.addAttribute("tournees", tournees);
		model.addAttribute("secteurs", site.getSecteurs());
		System.out.println("TourneeController : tournee() method ... ");
		return "tournee/tournee";
	}
	
	@RequestMapping(value = "/ajouttournee/", method = RequestMethod.GET)
	public String ajouterTourneeForm(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		List<Secteur> secteurs = site.getSecteurs();
		model.addAttribute("secteurs", secteurs);
		return "tournee/ajouttournee";
	}
	
	
	@RequestMapping(value = "/ajouttournee/", method = RequestMethod.POST)
	public String ajouterFacteur(@ModelAttribute("tournee") Tournee tournee, Model model, HttpServletRequest request, @RequestParam("codepostal") String codePostal) {
		int i=0;
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		Secteur s = secteurService.findOne("codePostal", codePostal);
		while(i<s.getTournees().size() && s.getTournees().get(i).getNumTournee()!=tournee.getNumTournee()) {
			i++;
		}
		if(i<s.getTournees().size()) {
			model.addAttribute("errormsg", "Un problème a été detecté lors de l'enregistrement du nouveau facteur.");
			model.addAttribute("secteurs", site.getSecteurs());
			System.out.println(tournee.toString());
			return "tournee/ajouttournee";
		}
		else {
			model.addAttribute("successmsg", "La nouvelle tournée a été bien ajoutée.");
			model.addAttribute("secteurs", site.getSecteurs());
			tournee.setSecteur(s);
			tourneeService.save(tournee);
			return "tournee/ajouttournee";
		}
	}
	
	@RequestMapping(value = "/supprimer/{idTournee}", method=RequestMethod.GET)
	public String supprimerFacteur(Model model, @PathVariable Long idTournee) {
		if (idTournee != null) {
			Tournee tournee = tourneeService.getById(idTournee);
			if (tournee != null) {
				tourneeService.remove(idTournee);
			}
		}
		return "redirect:/tournee/";
	}
	
	@RequestMapping(value = "/modifier/{idTournee}", method = RequestMethod.POST)
	public String modifierFacteur(Model model, @PathVariable Long idTournee, @ModelAttribute("tournee") Tournee tournee, @RequestParam("codePostal") String codePostal ) {
		Secteur s = secteurService.findOne("codePostal", codePostal);
		if (idTournee != null) {
			Tournee t = tourneeService.getById(idTournee);
			tournee.setIdT(idTournee);
			tournee.setSecteur(s);
			t=tournee;
			tourneeService.update(t);
		}
		return "redirect:/tournee/";
	}
	
	@RequestMapping(value="/importerexporter/")
	public String importerExporter() {
		return "tournee/importerexporter";
	}
	
	@RequestMapping(value="/exportlisttour/", method=RequestMethod.GET)
	public ModelAndView getExcelTournee(HttpServletRequest request) {
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		
		List<Tournee> tournees = new ArrayList<Tournee>();
		
		for(int i=0;i<site.getSecteurs().size();i++) {
				tournees.addAll(site.getSecteurs().get(i).getTournees());
		}
		
		ModelAndView model = new ModelAndView(new TourneeExcelReportView());
		model.addObject("tournees", tournees);
		return model;
	}
	
}
