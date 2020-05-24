package com.senactec.ondetemleitoapi.model.response;

import com.senactec.ondetemleitoapi.model.Usuario;

public class UsuarioLogadoResponse {
	
	private UsuarioResponse usuario;
	private TokenResponse token;

	
	public UsuarioResponse getUsuario() {return usuario;}
	public TokenResponse getToken() {return token;}

	public void converte(Object principal, String token, String tipoAuthentication) {
		
		this.usuario = new UsuarioResponse(principal);
		this.token = new TokenResponse(token, tipoAuthentication);
	}

	
	
	/**
	 * Dados ao usuário, após o login
	 */
	public final class UsuarioResponse {
		
		private Long id;
		private String login;
		private String nome;
		private String email;
		private String dataUltimoLogin;
		
		public  UsuarioResponse (Object principal) 
		{
			Usuario user = (Usuario) principal;
			id = user.getId();
			login = user.getLogin();
			nome = user.getNome();
			email = user.getEmail();
		
		}
			
		
		public Long getId() {return id;}
		public String getLogin() {return login;}
		public String getNome() {return nome;}
		public String getEmail() {return email;}
		public String getDataUltimoLogin() {return dataUltimoLogin;}
		
	}


	
	/**
	 * Dados referente ao token gerado após o login
	 */
	private  final class TokenResponse {
		
		private String tokenId;
		private String tipo;
	
		public TokenResponse(String token, String tipoAuthentication) {
			this.tokenId = token;
			this.tipo = tipoAuthentication;
		}


		public String getTokenId() {return tokenId;	}
		public String getTipo() {return tipo;}
	}
	
	

}
