package com.tp13.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tp13.models.Client;

@Controller
public class clientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${end.point}")
	private String url;
	
	
	
	@GetMapping("/delete-client/{id}")
	String delete(@PathVariable long id) {
		
		restTemplate.delete(url+"/clients/"+id);
		return "redirect:/client/all";
		
	}
	
	
	@PostMapping("/add-client")
	String add(@ModelAttribute("abc") Client c) {
		
		restTemplate.postForObject(url+"/clients/add",c,Client.class );
		return "redirect:/client/all";
		
	}
	
	@GetMapping("/update-client/id")
	String showClient(@PathVariable long id,RedirectAttributes AT){
		
		Client c=restTemplate.getForObject(url+"/clients/",Client.class);
		AT.addAttribute("abc",new Client());
		return "redirect:/client/all";
		
	}	
	
	
	@GetMapping( value={"/all" ,  "/clients"})
	String getAll(Model model ,@ModelAttribute("abc")  Client c){
		
		List<Client>lc=restTemplate.getForObject(url+"/clients/all",List.class);
		model.addAttribute("key1",lc);
		model.addAttribute("abc",new Client());
		return "index";
		
	}
	

	

	
	
	
}
