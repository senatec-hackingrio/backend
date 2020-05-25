package com.senactec.ondetemleitoapi.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.senactec.ondetemleitoapi.model.Usuario;
import com.senactec.ondetemleitoapi.model.request.FormCadastroUsuarioRequest;

import com.senactec.ondetemleitoapi.repository.UsuarioRepository;




@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	/**
	 * Cria um novo usuário e retorna o objeto usurio criado, sem os dados sensiveis
	 */
	public void newUsuario(FormCadastroUsuarioRequest formCadastroUsuarioRequest) {

		Usuario usuario = formCadastroUsuarioRequest.converte();
		usuarioRepository.save(usuario);
	}
	
	
	
	/**
	 * Pesquisa usuário por ID
	 */
	public Usuario findUsuarioById(Long id) {
		
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
	}

	
	


	
	
	/**
	 * Atualiza dados do usuário
	 */
	public void updateUsuario(Usuario usuario) {
		
		if(usuarioRepository.findById(usuario.getId()).isPresent()) 
			usuarioRepository.save(usuario);
	}
	
	


	
	
	

	
	
	
	
}
