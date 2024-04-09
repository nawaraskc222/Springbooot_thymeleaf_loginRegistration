package com.Spring_thymeleaf_FormHandle.Spring_thymeleaf_FormHandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
		@Autowired 
		RegistrationService service;
	
	@GetMapping("/")
	public String index(Model model ) {
		
		String imagePath = "/images/images.png";
        model.addAttribute("imagePath", imagePath);

		return "index";
	}

	@PostMapping("/homeAction")
	public String homeAction(@RequestParam String email, @RequestParam String password, Model model) {
		
//        Registration registration = service.findByEmailAndPassword(email, password);

        
        
        if (service.isAdmin(email, password)) {
            // Redirect to admin page if admin
            return "adminPage";
        } else {
            Registration registration = service.findByEmailAndPassword(email, password);
            if (registration != null) {
                // Redirect to home page if user is authenticated
                return "home";
            } else {
                // Add error message to the model and return to login page
                model.addAttribute("error", "Invalid email or password");
                return "redirect:/";
            }
		
	}
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
		
		service.save(registration);
		
		return "redirect:/";
	}

	
}
