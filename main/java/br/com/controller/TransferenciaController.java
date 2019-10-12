package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Transferencia;
import br.com.servico.TransferenciaServico;

@RestController
public class TransferenciaController {
	
	@Autowired
	private TransferenciaServico servico;
	
	@PostMapping(value = "/add/transferencia")
	public ResponseEntity<?> salvar(@RequestBody Transferencia transferencia) {
		try {
			servico.salvar(transferencia);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value="/listar/transferencias")
	public Object listar() {
		try {
			return servico.listarTodos();
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/listar/transferencia/{id}")
	public Object listarId(Long id) {
		try {
			return servico.listarPorId(id);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/delete/transferencia/{id}")
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
