package com.senactec.ondetemleitoapi.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Perfil implements GrantedAuthority {

	
	private static final long serialVersionUID = 1L;
	
	/* Construtores */
	public Perfil() { 
	}
	
	public Perfil(Long id) { 
		this.id = id;
	}
	
	public Perfil(Long id, String nome) { 
		this.id = id; 
		this.nome = nome;
	}


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;	}

	public String getNome() {return nome;	}
	public void setNome(String nome) {this.nome = nome;	}

	
	@Override
	public String getAuthority() {
		return this.getNome();
	}
	
		
}
