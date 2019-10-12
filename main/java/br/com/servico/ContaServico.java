package br.com.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entity.Conta;
import br.com.interfaces.ServicesInterface;
import br.com.repository.ContaRepository;

@Service
public class ContaServico implements ServicesInterface<Object> {

	@Autowired
	private ContaRepository repositorio;
	
	@Override
	public List<Conta> listarTodos() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<Conta> listarPorId(Long id) {
		return repositorio.findById(id);
	}
	
	@Override
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public void salvar(Object object) {
		repositorio.save((Conta) object);
	}
	
}
