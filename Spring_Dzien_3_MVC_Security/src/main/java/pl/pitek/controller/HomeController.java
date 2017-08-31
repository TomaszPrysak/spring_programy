package pl.pitek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// jest to uwieżytelnianie metodą

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/secured")
	public String secured(){
		return "secured";
	}
	
	@RequestMapping("/supersecured")
	public String supersecured(){
		return "supersecured";
	}
	
	@RequestMapping("/logowanie") // ten andres jest wywoływany przez SecurityConfig nigdzie indzej nie jest używany. Chodzi o to, że to jest nasza strona pośrednia między stroną główną a zawartością w części za hasłem.
	public String logowanie(){
		return "logowanie";
	}
}