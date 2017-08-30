package pl.reaktor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reaktor.model.Contact;
import pl.reaktor.model.Posts;
import pl.reaktor.model.Register;
import pl.reaktor.repository.PostsRepo;
import pl.reaktor.repository.RegisterRepo;

@Controller
public class BlogController {
	
	private RegisterRepo rr;
	private PostsRepo pr;
	
	@Autowired
	public BlogController(RegisterRepo rr, PostsRepo pr){
		this.rr = rr;
		this.pr = pr;
	}
	
	@RequestMapping("/")
	public String about(){
		return "about";
	}
	@PostMapping("/blog")
	public String blog(@ModelAttribute Register reg, Model model){
		model.addAttribute("reg", reg);
		
		List<Register> rs = rr.findAllByLoginAndPassword(reg.getLogin(), reg.getPassword());
		
		if(rs.isEmpty()){
			return"errorPage";
		}else{
			model.addAttribute("post", new Posts());
			return "blog";
		}
	}
	@PostMapping("/add")
	public String add(@ModelAttribute Posts post, Model model){
		pr.save(post);
		List<Posts> all = pr.findAll();
		model.addAttribute("app", all);	
		return "add";
	}
	@RequestMapping("/contact")
	public String contact(Model model){
		model.addAttribute("c", new Contact());
		return "contact";
	}
	@PostMapping("/success")
	public String success(@ModelAttribute Contact c, Model model){
		model.addAttribute("c",c);	
		return "success";
	}
	
	@RequestMapping("/registerForm")
	public String register(Model model){
		model.addAttribute("reg", new Register());
		return "registerForm";
	}
	
	@PostMapping("/saveRegister")
	public String saveRegister(@ModelAttribute Register reg, Model model){
		rr.save(reg);
		model.addAttribute("reg", reg);
		return "saveRegister";
	}
	
	@ RequestMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("reg", new Register());
		return "loginForm";
	}
	
}