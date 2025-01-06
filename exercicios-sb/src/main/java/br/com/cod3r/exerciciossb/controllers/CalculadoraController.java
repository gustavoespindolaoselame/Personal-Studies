package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/calculadora")
public class CalculadoraController {
	
	@GetMapping(path="/somar/{val1}/{val2}")
	public int soma(@PathVariable int val1,@PathVariable int val2) {
		return val1 + val2;
	}
	
	@GetMapping(path="/subtrair")
	public int subtrair(@RequestParam(name="a", defaultValue = "0") int val1, 
			@RequestParam(name="b", defaultValue = "0") int val2) {
		return val1-val2;
	}
}
