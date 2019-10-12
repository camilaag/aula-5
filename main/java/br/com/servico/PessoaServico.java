package br.com.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entity.Pessoa;
import br.com.interfaces.ServicesInterface;
import br.com.repository.PessoaRepository;

@Service
public class PessoaServico implements ServicesInterface<Object> {

	@Autowired
	private PessoaRepository repositorio;

	@Override
	public void salvar(Object object) {
		repositorio.save((Pessoa) object);
	}

	@Override
	public List<Pessoa> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Pessoa> listarPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
}
