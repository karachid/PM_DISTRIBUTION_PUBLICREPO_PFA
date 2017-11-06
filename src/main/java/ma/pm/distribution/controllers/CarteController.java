package ma.pm.distribution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cartesite")
public class CarteController {
	
	@RequestMapping(value="/")
	public String tableauBord() {
		return "carte/carte";
	}
	
}
