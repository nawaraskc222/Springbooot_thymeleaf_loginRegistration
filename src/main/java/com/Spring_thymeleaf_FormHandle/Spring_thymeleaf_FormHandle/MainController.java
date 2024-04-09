package com.Spring_thymeleaf_FormHandle.Spring_thymeleaf_FormHandle;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/")
	public String index(Model model ) {
		
		String imagePath = "/images/images.png";
        model.addAttribute("imagePath", imagePath);

		return "index";
	}
	
	@GetMapping("/register")
	public String registerFun(Model model) {
		model.addAttribute("register", new Registration());
		return "registration";
	}

	@PostMapping("/registerAction")
	public String registerAction(@ModelAttribute Registration registration,Model model ) {
		
		String n3 =registration.getEmail();
		String n1=registration.getFname();
		
		String n2=registration.getLname();
		String n4=registration.getPassword();
		
		
		System.out.println("First Name: " + n1);
		System.out.println("Last Name: " + n2);
		System.out.println("Email: " + n3);
		System.out.println("Password: " + n4);
		
		return "redirect:/";
	}

	
	@PostMapping("/homeAction")
	public String homeAction() {
		return "home";
	}
}
