package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Conta;
import br.com.servico.ContaServico;

@RestController
public class ContaController {

	@Autowired
	private ContaServico servico;

	@PostMapping(value = "/add/conta")
	public ResponseEntity<?> salvar(@RequestBody Conta conta) {
		try {
			servico.salvar(conta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value="/listar/conta")
	public Object listar() {
		try {
			return servico.listarTodos();
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/listar/conta/{id}")
	public Object listarId(Long id) {
		try {
			return servico.listarPorId(id);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/delete/conta/{id}")
	public ResponseEntity<?> deletar(Long id) {
		try {
			servico.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
