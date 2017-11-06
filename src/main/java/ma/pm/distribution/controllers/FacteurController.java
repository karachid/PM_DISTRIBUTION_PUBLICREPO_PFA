package ma.pm.distribution.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ma.pm.distribution.entities.Facteur;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.entities.Tenue;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.IFacteurService;
import ma.pm.distribution.services.ISiteService;
import ma.pm.distribution.services.ITenueService;
import ma.pm.distribution.xlsview.FacteurExcelReportView;

@Controller
@RequestMapping(value="/facteur")
public class FacteurController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private ITenueService tenueService;
	
	@Autowired
	private IFacteurService facteurService;
	
	@Autowired
	private ISiteService siteService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String facteur(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		//System.out.println("Rachid SITE : " + site.toString());
		
		List<Facteur> facteurs = new ArrayList<Facteur>();
		
		for(int i=0;i<site.getSecteurs().size();i++) {
			//System.out.println("Secteur = " + site.getSecteurs().get(i).getCodePostal()); 
			for(int j=0;j<site.getSecteurs().get(i).getTournees().size();j++) {
				//System.out.println("Tournee = " + site.getSecteurs().get(i).getTournees().get(j).getNumTournee());
				for(int k=0;k<site.getSecteurs().get(i).getTournees().get(j).getFacteurs().size();k++) {
					facteurs.add(site.getSecteurs().get(i).getTournees().get(j).getFacteurs().get(k).getFacteur());
				}
			}
		}
		
		List<Facteur> facteursLibresMnt = site.getFacteursLibres();
		/*for(Facteur f : facteursLibresMnt) {
			System.out.println(" ########### " + f.getNom() + " " + f.getPrenom());
		}*/
		
		facteurs.addAll(facteursLibresMnt);
		
		model.addAttribute("facteurs", facteurs);
		System.out.println("FacteurController : facteur() method ... ");
		return "facteur/facteur";
	}
	
	@RequestMapping(value = "/ajoutfacteur/", method = RequestMethod.GET)
	public String ajouterFacteurForm() {
		return "facteur/ajoutfacteur";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/ajoutfacteur/", method = RequestMethod.POST)
	public String ajouterFacteur(@ModelAttribute("facteur") Facteur facteur, @ModelAttribute("tenue") Tenue tenue, Model model, HttpServletRequest request) {
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		
		try {
			Tenue t = tenueService.save(tenue);
			
			if(t!=null) {
				System.out.println(t.toString()); 
			}
			
			facteur.setTenue(t);
			facteur.setSite(site); 
			
			Facteur f = facteurService.save(facteur);
			
			model.addAttribute("successmsg", "Le nouveau facteur a été bien ajouté.");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errormsg", "Un problème a été detecté lors de l'enregistrement du nouveau facteur.");
		}
		finally {
			return "facteur/ajoutfacteur";
		}
		
		
	}
	
	@RequestMapping(value = "/modifier/{idFacteur}", method = RequestMethod.POST)
	public String modifierFacteur(Model model, @PathVariable Long idFacteur, @ModelAttribute("facteur") Facteur facteur, @ModelAttribute("tenue") Tenue tenue) {
		if (idFacteur != null) {
			Facteur f = facteurService.getById(idFacteur);
			facteur.setIdF(idFacteur);
			facteur.setSite(f.getSite());
			facteur.setTenue(f.getTenue());
			f=facteur;
			facteurService.update(f);
			Tenue t = f.getTenue();
			tenue.setIdT(t.getIdT());
			t=tenue;
			tenueService.update(t);		
		}
		return "redirect:/facteur/";
	}
	
	@RequestMapping(value="/getFacteur/", method=RequestMethod.GET)
	@ResponseBody
	public Facteur getFacteurById(@RequestParam("identFacteur") Long facteurId) {
		System.out.println("#### HOHO 1 ####");
		Facteur f = facteurService.getById(facteurId);
		System.out.println(f.toString());
		System.out.println("#### HOHO 2 ####");
		return f;
	}
	
	@RequestMapping(value = "/supprimer/{idFacteur}", method=RequestMethod.GET)
	public String supprimerFacteur(Model model, @PathVariable Long idFacteur) {
		if (idFacteur != null) {
			Facteur facteur = facteurService.getById(idFacteur);
			if (facteur != null) {
				facteurService.remove(idFacteur);
			}
		}
		return "redirect:/facteur/";
	}
	
	@RequestMapping(value="/importerexporter/")
	public String importerExporter() {
		return "facteur/importerexporter";
	}
	
	
	@RequestMapping(value="/exportlistfact/", method=RequestMethod.GET)
	public ModelAndView getExcelFacteur(HttpServletRequest request) {
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		
		List<Facteur> facteurs = new ArrayList<Facteur>();
		
		for(int i=0;i<site.getSecteurs().size();i++) {
			for(int j=0;j<site.getSecteurs().get(i).getTournees().size();j++) {
				for(int k=0;k<site.getSecteurs().get(i).getTournees().get(j).getFacteurs().size();k++) {
					//facteurs.add(site.getSecteurs().get(i).getTournees().get(j).getFacteurs().get(k));
				}
			}
		}
		
		List<Facteur> facteursLibresMnt = site.getFacteursLibres();
		
		
		facteurs.addAll(facteursLibresMnt);
		ModelAndView model = new ModelAndView(new FacteurExcelReportView());
		model.addObject("facteurs", facteurs);
		return model;
	}
	
	
	@RequestMapping(value="/importfacteurs", method = RequestMethod.POST)
	public String processExcel(Model model, @RequestParam("excelfile") MultipartFile excelfile) {
		List<Facteur> l=null;
		try {
			if(excelfile.getOriginalFilename().endsWith(".xls")) {
				l = facteurService.facteurImportXls(excelfile);
				for(int i=0;i<l.size();i++) {
					facteurService.save(l.get(0));
				}
			} else if(excelfile.getOriginalFilename().endsWith(".xlsx")) {
				l = facteurService.facteurImportXlsx(excelfile);
				for(int i=0;i<l.size();i++) {
					facteurService.save(l.get(0));
				}
			}else {
				throw new Exception();
			}
		}catch(Exception ex) {
			model.addAttribute("errorMsg","Un problème est rencontré lors de l'import du fichier, veuillez vérifier le type / contenu du fichier chargé");
			return "facteur/importerexporter";
		}
		return "facteur/importerexporter";
	}
 
}
	

	
