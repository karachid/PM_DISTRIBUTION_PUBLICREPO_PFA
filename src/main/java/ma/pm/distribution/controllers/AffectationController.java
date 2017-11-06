package ma.pm.distribution.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ma.pm.distribution.entities.Affectation;
import ma.pm.distribution.entities.Facteur;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.entities.Tenue;
import ma.pm.distribution.entities.Tournee;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.IAffectationService;
import ma.pm.distribution.services.IFacteurService;
import ma.pm.distribution.services.ISecteurService;
import ma.pm.distribution.services.ISiteService;
import ma.pm.distribution.services.ITenueService;
import ma.pm.distribution.services.ITourneeService;

@Controller
@RequestMapping(value="/affectation")
public class AffectationController {
	
	@Autowired
	private ISecteurService secteurService;
	
	@Autowired
	private ISiteService siteService;
	
	@Autowired
	private ITourneeService tourneeService;
	
	@Autowired
	private IFacteurService facteurService;
	
	@Autowired
	private IAffectationService affectationService;
	
	@Autowired
	private ITenueService tenueService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value="/")
	public String affectation(Model model, HttpServletRequest request) {
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		List<Affectation> listAffectations = new ArrayList<>();
		for(int i=0;i<site.getSecteurs().size();i++) {
			for(int j=0;j<site.getSecteurs().get(i).getTournees().size();j++) {
				listAffectations.addAll(site.getSecteurs().get(i).getTournees().get(j).getFacteurs());
			}
		}
		//for(Affectation aff : listAffectations)System.out.println("Identifiant de l'affectation : " + aff.getIdF().getFacteurId()+ " || " + aff.getIdF().getTourneeId() + " || " + aff.getFacteur().getNom() + " || " + aff.getTournee().getNatureTournee());
		model.addAttribute("affectations", listAffectations);
		return "affectation/affectation";
	}
	
	
	@RequestMapping(value="/ajoutaffectation")
	public String ajoutAffectation(Model model, HttpServletRequest request) {
	
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		
		int cpt=0;
		for(int i=0;i<site.getSecteurs().size();i++) {
				cpt+=site.getSecteurs().get(i).getTournees().size();
			}
		
		
		List<Facteur> f = site.getFacteursLibres();
		
		List<Tournee> ll = tourneeService.selectAll();
		List<Tournee> l = tourneeService.findByAttribute("estLibre", true,"nomSite", user.getNomSite());
		List<Tournee> lll = tourneeService.findByAttribute("estLibre", false,"nomSite", user.getNomSite());
		System.out.println("nbre de tournées libres : " + l.size());
		System.out.println("nbre total des tournées : " + ll.size());
		System.out.println("nbre de tournées occupées : " + lll.size());
		
		System.out.println("nombre de tournees du site : " + user.getNomSite() + " est égale : " + cpt);
		
		System.out.println("nombre de facteur libres : " + f.size());
		
		for(Facteur fu : f)System.out.println(fu.getNom()); 
		
		model.addAttribute("factsLibres", f);
		model.addAttribute("toursLibres", l);
		
		model.addAttribute("secteurs", site.getSecteurs());  
		
		return "affectation/ajoutaffectation";
	}
	
	@RequestMapping(value="/gettourneeslibres", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public List<Integer> tourneeLibresSecteur(@RequestParam("codePostal") String cp){
		List<Tournee> tournees = secteurService.findOne("codePostal", cp).getTournees();
		List<Integer> tr = new ArrayList<Integer>();
		for(int i=0;i<tournees.size();i++) {
			if(tournees.get(i).isEstLibre()) {
				tr.add(Integer.parseInt(tournees.get(i).getIdT().toString()));
				tr.add(tournees.get(i).getNumTournee());
			}
		}
		return tr;
	}
	
	
	@RequestMapping(value="/affecter/", method = RequestMethod.POST)
	public String affecter(Model model, @RequestParam("idFact") Long factId, @RequestParam("idTour") Long tourId, @RequestParam("df") Date df, @RequestParam("observationAff") String of ) {
		System.out.println("RCA");
		Facteur f=null;
		Tournee t=null;
		if(factId!=null && tourId!=null) {
//			System.out.println("IDF" + factId);
//			System.out.println("IDT" + tourId);
//			System.out.println("Date" + df);
//			System.out.println("Observation" + of);
			f = facteurService.getById(factId);
			t = tourneeService.getById(tourId);
			f.setSite(null);
			t.setEstLibre(false);
			facteurService.update(f);
			tourneeService.update(t);
			Affectation af = new Affectation(t, f);
			af.setDateAffectation(df);
			af.setObservationAff(of);
			affectationService.saveAff(af);
			model.addAttribute("successmsg","Le facteur " + f.getNom()+ " " + f.getPrenom() + " est affecté à la tournée " + t.getSecteur().getCodePostal()+"-"+t.getNumTournee());
		}
		//model.addAttribute("msg", "Le facteur " + f.getNom() + " " + f.getPrenom() + " a été affecté à la tournée " + t.getSecteur().getCodePostal()+"-"+t.getNumTournee());

		//System.out.println("NOM : " + f.getNom());
		//System.out.println("NUM TOURNEE : " + t.getNumTournee());
		//return "redirect:/affectation/ajoutaffectation";
		return "affectation/ajoutaffectation";
	}
	
	@RequestMapping(value="/update/", method = RequestMethod.POST)
	public String mettreAJour(HttpServletRequest request, @RequestParam("observationAff") String of, @RequestParam("df") Date df, @RequestParam("ff") Date ff, @RequestParam("idAff") Long idF, @RequestParam("idTour") Long idT, @RequestParam("idFact") Long idFa) {
		System.out.println("################################### UPDATE #####################################");
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		Site site = siteService.findOne("nomSite", user.getNomSite());
		
		System.out.println("Observation : "  + of);
		System.out.println("DF : "  + df);
		System.out.println("FF : "  + ff);
		System.out.println("ID AFF : " + idF);
		System.out.println("ID Fact : " + idFa);
		System.out.println("ID Tour : " + idT);
		Tournee t = tourneeService.getById(idT);
		Facteur f = facteurService.getById(idFa);
		Affectation af = affectationService.getById(idF);
		if(t!=null) {
			System.out.println("Numéro de la tournée : " + t.getNumTournee());
		}
		if(f!=null) {
			System.out.println("Matricule du facteur : "+f.getMatricule());
		}
		if(af!=null) {
			System.out.println("Id de l'affectation : "+af.getIdF());
		}
		af.setDateFinAffectation(ff);
		af.setObservationAff(of);
		affectationService.update(af);
		f.setSite(site);
		facteurService.update(f);
		t.setEstLibre(true);
		tourneeService.update(t);
		return "";
		//return "affectation/affectation";
	}
	
	
}
