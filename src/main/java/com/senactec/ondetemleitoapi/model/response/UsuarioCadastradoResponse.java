package com.senactec.ondetemleitoapi.model.response;

import java.util.List;
import java.util.stream.Collectors;

import com.senactec.ondetemleitoapi.model.Usuario;


public class UsuarioCadastradoResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String perfil;
	
	
	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;	}

	public String getNome() {return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}

	public String getEmail() {	return email;	}
	public void setEmail(String email) {this.email = email;	}

	public String getLogin() {	return login;	}
	public void setLogin(String login) {this.login = login;	}

	public String getPerfil() {return perfil;}
	public void setPerfil(String perfil) {this.perfil = perfil;	}

	public UsuarioCadastradoResponse() { }
	
	public UsuarioCadastradoResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.login = usuario.getLogin();
		this.perfil = usuario.getPerfil().getNome();
				
	}
	
	
	public static List<UsuarioCadastradoResponse> converte(List<Usuario> usuarios) {
		
		return usuarios.stream()
				.map(UsuarioCadastradoResponse::new)
				.collect(Collectors.toList());
		
	}
	
	

	
	
	

}
