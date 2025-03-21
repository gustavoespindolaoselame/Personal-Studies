package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.Cliente;

@RestController
@RequestMapping(path="/clientes")
public class ClienteController {
	
	@GetMapping(path="/qualquer")
	public Cliente getCliente() {
		return new Cliente(28,"Pedro", "123.456.789-00", 10000000000000000.50, 209.99, 0.000456);
	}
	
	@GetMapping(path="/{id}")
	public Cliente getClientePorID1(@PathVariable int id) {
		return new Cliente(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping
	public Cliente getClientePorID2(@RequestParam(name="id", defaultValue = "1") int id) {
		return new Cliente(id, "João Augusto", "112.233.445-00");
	}
}
