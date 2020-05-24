package com.senactec.ondetemleitoapi.model.request;

import com.senactec.ondetemleitoapi.model.Perfil;
import com.senactec.ondetemleitoapi.model.Usuario;
import com.senactec.ondetemleitoapi.util.SenhaUtil;

public class FormCadastroUsuarioRequest {

	private String nome;
	private String email;
	private String login;
	private String senha;
	private Long idPerfil;
	

	public String getNome() {return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}

	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	public String getLogin() {	return login;	}
	public void setLogin(String login) {	this.login = login;	}

	public String getSenha() {return senha;	}
	public void setSenha(String senha) {	this.senha = senha;	}


	public Long getIdPerfil() {	return idPerfil;	}
	public void setIdPerfil(Long idPerfil) {	this.idPerfil = idPerfil;	}


	public Usuario converte() {

		Usuario usuario = new Usuario();
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setLogin(this.login);
		usuario.setSenha(SenhaUtil.criptoSenha(this.senha));
		usuario.setPerfil(getPerfil());
		
		return usuario;
	}
	
	
	private Perfil getPerfil() {
				
		boolean semPerfil =  idPerfil == null;
		if(semPerfil) this.idPerfil = 2L; 
		
		Perfil perfil = new Perfil();
		perfil.setId(idPerfil);
		
		return  perfil;
	}

}
