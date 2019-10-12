package br.com.interfaces;

public interface ServicesInterface<T> {

	public void salvar(T object);
	public Object listarTodos();
	public Object listarPorId(Long id);
	public void deletar(Long id);
	
}