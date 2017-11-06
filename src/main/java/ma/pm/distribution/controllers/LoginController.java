package ma.pm.distribution.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import ma.pm.distribution.entities.DRAP;
import ma.pm.distribution.entities.Region;
import ma.pm.distribution.entities.Site;
import ma.pm.distribution.entities.Utilisateur;
import ma.pm.distribution.services.IDrapService;
import ma.pm.distribution.services.IRegionService;
import ma.pm.distribution.services.IUtilisateurService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private IDrapService drapService;
	
	@Autowired
	private IRegionService regionService;
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	
	@RequestMapping(value="/login/{type}")
	public String login(@PathVariable("type") String type, Model model) {
		List<DRAP> drapList;
		if(type.equals("siege")) {
			return "/login/loginsiege";
		}else if(type.equals("region")) {
			drapList=drapService.selectAll();
			String msg = (String) model.asMap().get("msgEmptyFields");
			model.addAttribute("msgEmptyFields", msg);
			model.addAttribute("drapList",drapList);
			return "/login/loginregion";
		}else {
			drapList=drapService.selectAll();
			model.addAttribute("drapList",drapList);
			System.out.println("*****************************************HERE****************************************************");
			return "/login/loginsite";
		}
	
	}
	
	/*
	@RequestMapping(value="/login/")
	public String login(@RequestParam("type") String typeProfil, Model model) {
		List<DRAP> drapList;
		if(typeProfil.equals("region") || typeProfil.equals("site")) {
			drapList=drapService.selectAll();
		}
		else {
			drapList=new ArrayList<DRAP>();
		}
		model.addAttribute("type", typeProfil);
		model.addAttribute("drapList",drapList);
		return "/login/login";
	}
	*/
	
	@RequestMapping(value="/getRegions/", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public List<String> getSiteList(@RequestParam("nameDrap") String drapName ){
		List<Region> lr = drapService.findOne("drap", drapName).getRegions();
		System.out.println("Les regions : " + lr.size());
		List<String> ls = new ArrayList<String>();
		for(int i=0;i<lr.size();i++) {
			ls.add(lr.get(i).getNomRegion());
		}
		return  ls;
	} 
	
	@RequestMapping(value="/getSitesRegion/", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public List<String> getRegionList(@RequestParam("nomRegion") String nomRegion ){
		System.out.println("######## NEW METHOD ######## : param value = " + nomRegion);
		List<Site> lSites = regionService.findOne("nomRegion", nomRegion).getSites();
		System.out.println("Les sites : " + lSites.size());
		List<String> lNomsSites = new ArrayList<String>();
		for(int i=0;i<lSites.size();i++) {
			lNomsSites.add(lSites.get(i).getNomSite());
		}
		return lNomsSites;
	} 
	
	
	@RequestMapping(value="/logincheckersiege/", method=RequestMethod.POST)
	public String loginCheckerSiege(@ModelAttribute("user") Utilisateur user) {
		System.out.println("TEST ## SIEGE");
		System.out.println(user.toString());
		return "facteur/facteur";
	}
	
	@RequestMapping(value="/logincheckersite/", method=RequestMethod.POST)
	public ModelAndView loginCheckerSite(@ModelAttribute("user") Utilisateur user, RedirectAttributes ra, HttpServletRequest request) {
		List<Object> listParams = new ArrayList<>();
		listParams.add("login");
		listParams.add("password");
		listParams.add("nomDrap");
		listParams.add("nomRegion");
		listParams.add("nomSite");
		List<Object> listValues = new ArrayList<>();
		listValues.add(user.getLogin());
		listValues.add(user.getPassword());
		listValues.add(user.getNomDrap());
		listValues.add(user.getNomRegion());
		listValues.add(user.getNomSite());
		if(!utilisateurService.isExist(listParams, listValues)) {
			ra.addFlashAttribute("msgEmptyFields","les données saisies sont incorrectes");
			return new ModelAndView("redirect:/login/login/site");
		}
		else {
			System.out.println("TEST ## SITE");
			request.getSession().setAttribute("user", user);
			System.out.println(user.toString());
			return new ModelAndView("redirect:/tableaubord/site");
		}
	}
	
	@RequestMapping(value="/logincheckerregion/", method=RequestMethod.POST)
	public ModelAndView loginCheckerRegion(@ModelAttribute("user") Utilisateur user, RedirectAttributes ra, HttpServletRequest request) {
		List<Object> listParams = new ArrayList<>();
		listParams.add("login");
		listParams.add("password");
		listParams.add("nomDrap");
		listParams.add("nomRegion");
		List<Object> listValues = new ArrayList<>();
		listValues.add(user.getLogin());
		listValues.add(user.getPassword());
		listValues.add(user.getNomDrap());
		listValues.add(user.getNomRegion());
		if(!utilisateurService.isExist(listParams, listValues)) {
			ra.addFlashAttribute("msgEmptyFields","les données saisies sont incorrectes");
			return new ModelAndView("redirect:/login/login/region");
		}
		else {
			System.out.println("TEST ## SITE");
			request.getSession().setAttribute("user", user);
			System.out.println(user.toString());
			return new ModelAndView("redirect:/tableaubord/region");
		}
	}
	
	@RequestMapping(value="/logout/")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "accueil/accueil";
	}
	

	
}
