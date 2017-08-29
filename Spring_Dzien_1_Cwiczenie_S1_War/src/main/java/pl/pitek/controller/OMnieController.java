package pl.pitek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OMnieController {
	
	@RequestMapping("/")
	public String OMnie(){
		return "o_mnie";
	}
	
	@RequestMapping("/blog")
	public String Blog(){
		return "blog";
	}
	
	@RequestMapping("/kontakt")
	public String Kontakt(){
		return "kontakt";
	}
	
}
