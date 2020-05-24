package com.senactec.ondetemleitoapi.model.response;

import com.senactec.ondetemleitoapi.model.Perfil;
import com.senactec.ondetemleitoapi.model.Usuario;

public class NovoUsuarioCadastradoResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String login;
	private Perfil perfil;
	
	
	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;	}

	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	public String getLogin() {return login;	}
	public void setLogin(String login) {this.login = login;	}

	public Perfil getPerfil() {	return perfil;	}
	public void setPerfil(Perfil perfil) {this.perfil = perfil;	}



	public NovoUsuarioCadastradoResponse converte(Usuario usuario) {
		
		NovoUsuarioCadastradoResponse usuarioResponse = new NovoUsuarioCadastradoResponse();
		usuarioResponse.id = usuario.getId();
		usuarioResponse.nome = usuario.getNome();
		usuarioResponse.login = usuario.getLogin();
		usuarioResponse.email = usuario.getEmail();
		
		usuarioResponse.perfil = new Perfil();
		usuarioResponse.perfil.setId(usuario.getPerfil().getId());
		usuarioResponse.perfil.setNome(usuario.getPerfil().getNome());
		
		return usuarioResponse;
	}

}
