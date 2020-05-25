package com.senactec.ondetemleitoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senactec.ondetemleitoapi.model.request.FormLoginUsuarioRequest;
import com.senactec.ondetemleitoapi.model.response.UsuarioLogadoResponse;
import com.senactec.ondetemleitoapi.service.AutenticationService;



@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	
	
	@Autowired
	private AutenticationService autenticatioService;

	
	@PostMapping
	public ResponseEntity<UsuarioLogadoResponse> autenticar(@RequestBody FormLoginUsuarioRequest loginUsuarioRequest){
		
		UsernamePasswordAuthenticationToken dadosLogin = loginUsuarioRequest.converter();
		
		UsuarioLogadoResponse usuarioLogadoResponse = 
				autenticatioService.autenticaUsuario(dadosLogin);
			
		return ResponseEntity.ok(usuarioLogadoResponse);
	}
	
}
