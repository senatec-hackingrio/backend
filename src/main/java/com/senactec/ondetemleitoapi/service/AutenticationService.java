package com.senactec.ondetemleitoapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.senactec.ondetemleitoapi.config.security.TokenService;
import com.senactec.ondetemleitoapi.model.Usuario;
import com.senactec.ondetemleitoapi.model.response.UsuarioLogadoResponse;


@Service
public class AutenticationService {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Realiza a autenticacao(login)/validação login do usuário
	 */
	public UsuarioLogadoResponse autenticaUsuario(UsernamePasswordAuthenticationToken dadosLogin) {
		
		Authentication authenticate = authManager.authenticate(dadosLogin);
		
		String token = tokenService.gerarToken(authenticate);
		
		Usuario usuario = (Usuario) authenticate.getPrincipal();
		
		UsuarioLogadoResponse usuarioLogadoResponse = new UsuarioLogadoResponse();
		usuarioLogadoResponse.converte(usuario,token,"Bearer");

		return usuarioLogadoResponse;	
		
	}
}
