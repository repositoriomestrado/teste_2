package br.com.wtsyst.controle.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.wtsyst.bean.Cliente;
import br.com.wtsyst.controle.ClienteBCI;
import br.com.wtsyst.dao.ClienteDAO;

@Controller
public class ClienteBC implements ClienteBCI {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	public void insert(Cliente c) {
		dao.save(c);
		
	}

	@Override
	public List<Cliente> select() {
		return dao.findAll();
	}

}
