package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
