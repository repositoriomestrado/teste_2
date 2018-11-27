package br.com.wtsyst.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_role", sequenceName = "role_seq", initialValue = 1)
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	private Integer id;
	private String perfil;
	private String descricao;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_pagina", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "pagina_id") })
	private List<Pagina> paginas;
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
