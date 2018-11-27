package br.com.wtsyst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wtsyst.bean.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
