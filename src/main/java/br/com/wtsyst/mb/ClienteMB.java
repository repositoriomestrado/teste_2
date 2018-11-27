package br.com.wtsyst.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.wtsyst.bean.Cliente;
import br.com.wtsyst.controle.ClienteBCI;


@ManagedBean(name = "ClienteMB")
@ViewScoped
public class ClienteMB extends SpringBeanAutowiringSupport {
	
	@Autowired
	private ClienteBCI controle;
	private Cliente cliente;
	private List<Cliente> list;
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.list = controle.select();
		
	}
	
	public void cadastrar() {
		this.controle.insert(this.cliente);
		this.init();
	}
	
}
