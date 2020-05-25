package com.senactec.ondetemleitoapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senactec.ondetemleitoapi.model.request.FormCadastroUsuarioRequest;
import com.senactec.ondetemleitoapi.model.response.NovoUsuarioCadastradoResponse;
import com.senactec.ondetemleitoapi.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<?> registraUsuario(@RequestBody FormCadastroUsuarioRequest formCadastroUsuarioRequest)
	{	
		usuarioService.newUsuario(formCadastroUsuarioRequest);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
