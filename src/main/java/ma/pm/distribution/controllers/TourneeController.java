package ma.pm.distribution.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.pm.distribution.entities.Tournee;
import ma.pm.distribution.services.ITourneeService;

@Controller
@RequestMapping(value="/tournee")
public class TourneeController {
	
	@Autowired
	private ITourneeService tourneeService;
	
	@RequestMapping(value="/")
	public String tournee(Model model) {
		List<Tournee> tournees = tourneeService.selectAll();
		if (tournees == null) {
			tournees = new ArrayList<Tournee>();
		}
		model.addAttribute("tournees", tournees);
		System.out.println("TourneeController : tournee() method ... ");
		return "tournee/tournee";
	}
}
