package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Pessoa;
import br.com.servico.PessoaServico;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaServico servico;

	@PostMapping(value = "/add/usuario")
	public ResponseEntity<?> salvar(@RequestBody Pessoa pessoa) {
		try {
			servico.salvar(pessoa);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value="/listar/pessoas")
	public Object listar() {
		try {
			return servico.listarTodos();
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/listar/pessoa/{id}")
	public Object listarId(Long id) {
		try {
			return servico.listarPorId(id);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/delete/pessoa/{id}")
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
