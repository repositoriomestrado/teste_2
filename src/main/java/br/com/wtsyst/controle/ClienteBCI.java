package br.com.wtsyst.controle;

import java.util.List;

import br.com.wtsyst.bean.Cliente;

public interface ClienteBCI {
	public void insert(Cliente c);
	
	public List<Cliente> select();
}
