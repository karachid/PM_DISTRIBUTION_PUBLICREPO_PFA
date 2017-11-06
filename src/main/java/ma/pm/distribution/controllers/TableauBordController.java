package ma.pm.distribution.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.pm.distribution.entities.KeyValue;
import ma.pm.distribution.entities.Region;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.IAffectationService;
import ma.pm.distribution.services.IFacteurService;
import ma.pm.distribution.services.IRegionService;
import ma.pm.distribution.services.ISecteurService;
import ma.pm.distribution.services.ISiteService;
import ma.pm.distribution.services.ITenueService;
import ma.pm.distribution.services.ITourneeService;

@Controller
@RequestMapping("/tableaubord")
public class TableauBordController {
	
	@Autowired
	private ISecteurService secteurService;
	
	@Autowired
	private IRegionService regionService;
	
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
	
	@RequestMapping(value="/site")
	public String tableauBordSite(Model model, HttpServletRequest request) {
		
		List<KeyValue> tourneesParSecteur = new ArrayList<KeyValue>();
		List<KeyValue> FacteursParSecteur = new ArrayList<KeyValue>();
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		
			System.out.println("site : " + user.getNomSite());
			Site site = siteService.findOne("nomSite", user.getNomSite());
			
			for(int i=0;i<site.getSecteurs().size();i++) {
				tourneesParSecteur.add(new KeyValue(site.getSecteurs().get(i).getCodePostal(), String.valueOf(site.getSecteurs().get(i).getTournees().size())));
			}
			
			for(int i=0;i<site.getSecteurs().size();i++) {
				int cpt=0;
				for(int j=0;j<site.getSecteurs().get(i).getTournees().size();j++) {
					cpt+=site.getSecteurs().get(i).getTournees().get(j).getFacteurs().size();
				}
				FacteursParSecteur.add(new KeyValue(site.getSecteurs().get(i).getCodePostal(),String.valueOf(cpt)));
			}
			
			model.addAttribute("tourneesPArSecteur",tourneesParSecteur);
			model.addAttribute("FacteursParSecteur",FacteursParSecteur);
		
		return "tableaubord/tableaubordsite";
	}
	
	@RequestMapping(value="/region")
	public String tableauBordRegion(Model model, HttpServletRequest request) {
		
		List<KeyValue> factsLibresParSite = new ArrayList<KeyValue>();
		List<KeyValue> nbreSectsParSite = new ArrayList<KeyValue>();
		
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
		
			System.out.println("region : " + user.getNomRegion());
			Region region = regionService.findOne("nomRegion", user.getNomRegion());
			
			
			for(int i=0;i<region.getSites().size();i++) {
				System.out.println("avant = "  + i);
				factsLibresParSite.add(new KeyValue(region.getSites().get(i).getNomSite(),String.valueOf(region.getSites().get(i).getFacteursLibres().size())));
				System.out.println("c = " +  region.getSites().get(i).getFacteursLibres().size());
				System.out.println("après = "  + i);
			}
			
			System.out.println("factsLibresParSite size : " + factsLibresParSite.size());
			
			for(int i=0;i<region.getSites().size();i++) {
				nbreSectsParSite.add(new KeyValue(region.getSites().get(i).getNomSite(), String.valueOf(region.getSites().get(i).getSecteurs().size())));
			}
			
			System.out.println(region.getSites().size());
			
			model.addAttribute("factsLibresParSite",factsLibresParSite);
			model.addAttribute("nbreSectsParSite",nbreSectsParSite);
		
		return "tableaubord/tableaubordregion";
		
	}
	
	
	
}
