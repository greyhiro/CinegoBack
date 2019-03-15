package fr.cesi.ril18.CineGoBack.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping
     public String home(){
         return "Hello World!";
     }
	
	@PostMapping
	public String helloName(@RequestBody String name) {
		
		String name1 = name;
		return "hello "+ name1;
		
	}
	


 }