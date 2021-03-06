package br.etec.sebrae.academico.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.etec.sebrae.academico.dto.Login;

@Controller
public class HomeController {
	
	final String url = "http://localhost:8001/login/v1/";
	RestTemplate rest = new RestTemplate();	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/lista")
	public ModelAndView listar() {
			
		ModelAndView modelAndView = new ModelAndView("listalogin");			
		ArrayList<Login> logins = rest.getForObject(url+"/consultar_login", ArrayList.class);		
		modelAndView.addObject(new Login());
		modelAndView.addObject("logins", logins);		
		return modelAndView;
	}
	
	@PostMapping("/salvar")
	public String salvar(Login login) {	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> map = new HashMap<>();
		map.put("login", login.getLogin());
		map.put("tipo", login.getTipo());
		map.put("nome", login.getNome());
		map.put("password", login.getPassword());
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map,headers);	
		
		ResponseEntity<Login> reponse = rest.postForEntity(url+"/adicionar_login", entity, Login.class);
		
		return"redirect:/lista";
	}
	

}