package pl.pitek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pitek.model.KontaktModel;
import pl.pitek.model.PostModel;

@Controller
public class BlogController {

	@RequestMapping("/")
	public String o_mnie(){
		return "o_mnie";
	}
	
	@RequestMapping("/blog")
	public String blog(Model model){
		model.addAttribute("post", new PostModel());
		return "blog";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute PostModel post, Model model){
		model.addAttribute("post", post);
		return "add";
	}
	
	@RequestMapping("/kontakt")
	public String kontakt(Model model){
		model.addAttribute("k", new KontaktModel());
		return "kontakt";
	}
	
	@GetMapping("/success")
	public String success(@ModelAttribute KontaktModel k, Model model){
		model.addAttribute("k", k);
		return "success";
	}
	
}
