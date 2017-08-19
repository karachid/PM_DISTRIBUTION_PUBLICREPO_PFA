package ma.pm.distribution.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.pm.distribution.entities.DRAP;
import ma.pm.distribution.entities.Region;
import ma.pm.distribution.services.IDrapService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private IDrapService drapService;
	
	/*
	@Autowired
	private IRegionService regionService;
	*/
	
	/*
	@Autowired
	private ISiteService siteService;
	*/
	
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
	
	
	@RequestMapping(value="/getRegions/", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public List<String> getRegionList(@RequestParam("nameDrap") String drapName ){
		List<Region> lr = drapService.findOne("drap", drapName).getRegions();
		List<String> ls = new ArrayList<String>();
		for(int i=0;i<lr.size();i++) {
			ls.add(lr.get(i).getNomRegion());
		}
		for(Region curr : lr)System.out.println(curr.toString());
		for(String curr : ls)System.out.println(curr);
		return  ls;
	} 
	
	
	/*
	@RequestMapping(value="/getRegions/", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getRegionList(@RequestParam("drapName") String drapName ){
		List<Region> lr = drapService.findOne("drap", drapName).getRegions();
		for(Region curr : lr)System.out.println(curr.toString()); 
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr=null;
        try {
            // get Employee object as a json string
        	jsonStr = mapperObj.writeValueAsString(lr);
            System.out.println("hhh : " + jsonStr);

	} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
		return  jsonStr;
	}
	*/
}
