package br.com.wtsyst.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_pagina", sequenceName = "pagina_seq", initialValue = 1)
public class Pagina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pagina")
	private Integer id;
	private String url;
	private String descricao;
	@ManyToMany(mappedBy = "paginas")
	private List<Role> roles;


	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

}
