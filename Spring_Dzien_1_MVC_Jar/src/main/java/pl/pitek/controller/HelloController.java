package pl.pitek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	//@GetMapping("adres")
	@RequestMapping("/")
	public String Hello(){ // metoda ta zwraca wynik w postaci naszego pliku hello.html
		return "hello";
	}
	
}
