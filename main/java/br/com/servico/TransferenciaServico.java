package br.com.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.entity.Transferencia;
import br.com.interfaces.ServicesInterface;
import br.com.interfaces.TransferenciaInterface;
import br.com.repository.TransferenciaRepository;

public class TransferenciaServico implements TransferenciaInterface, ServicesInterface<Object> {

	@Autowired
	private TransferenciaRepository repositorio;
	
	@Override
	public void salvar(Object object) {
		repositorio.save((Transferencia) object);
		
	}

	@Override
	public List<Transferencia> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Transferencia> listarPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}

}
