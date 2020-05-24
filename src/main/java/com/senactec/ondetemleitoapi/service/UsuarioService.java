package com.senactec.ondetemleitoapi.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.senactec.ondetemleitoapi.model.Usuario;
import com.senactec.ondetemleitoapi.model.request.FormCadastroUsuarioRequest;
import com.senactec.ondetemleitoapi.model.response.NovoUsuarioCadastradoResponse;
import com.senactec.ondetemleitoapi.model.response.UsuarioCadastradoResponse;
import com.senactec.ondetemleitoapi.repository.UsuarioRepository;
import com.senactec.ondetemleitoapi.util.SenhaUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	/**
	 * Cria um novo usuário e retorna o objeto usurio criado, sem os dados sensiveis
	 */
	public NovoUsuarioCadastradoResponse newUsuario(FormCadastroUsuarioRequest formCadastroUsuarioRequest) {

		Usuario usuario = formCadastroUsuarioRequest.converte();
		
		Usuario usuarioNew = usuarioRepository.save(usuario);
		
		return new NovoUsuarioCadastradoResponse().converte(usuarioNew);
	}
	
	
	
	/**
	 * Procura registro do usuário por email e retorna um boolean
	 */
	public boolean solicitaResetSenha(String email) {
		
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(email);

		if (usuarioByEmail.isPresent()) 
			registraSolicitacaoResetSenha(usuarioByEmail.get());
	
		return usuarioByEmail.isPresent();
	}
	

		
	
	/**
	 * Pesquisa usuário por ID
	 */
	public Usuario findUsuarioById(Long id) {
		
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}

	
	
	/**
	 * Retorna o usuário cadastrado, com o login informado
	 */
	public Usuario findByLogin(String login) {
		
		return usuarioRepository.findByLogin(login)
					.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
						
	}

	
	
	/**
	 * Atualiza dados do usuário
	 */
	public void updateUsuario(Usuario usuario) {
		
		if(usuarioRepository.findById(usuario.getId()).isPresent()) 
			usuarioRepository.save(usuario);
	}
	
	
	
	/**
	 * @return uma lista de usuários cadastrados
	 */
	public List<UsuarioCadastradoResponse> findAllUsuario() {
		
		List<Usuario> findAll = usuarioRepository.findAll();
		
		return UsuarioCadastradoResponse.converte(findAll);
	}

	
	
	
	
	// --------------------- //
	// Metodos privados  \/  //
	// --------------------- //
	
	
	/**
	 * Registra a solicitção de reset de senha
	 */
	private void registraSolicitacaoResetSenha(Usuario usuario) {
		
		String chaveUUID = UUID.randomUUID().toString() + usuario.getId();
		usuario.setResetSenhaUuid(chaveUUID);
		usuario.setResetSenha(true);

		usuarioRepository.save(usuario);	
	}

	
	
	/**
	 * Retorna o objeto usuário que possi uma solicitação de reset de senha valida
	 */
	private Usuario getRequestResetPassword(String uuidResetSenha) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository
				.findByResetSenhaUuidAndResetSenhaDataLimiteGreaterThanEqual(uuidResetSenha, LocalDateTime.now());
		
		if(usuarioOptional.isPresent())
			return usuarioOptional.get();
		
		return null;
	}
	
	
	
	/**
	 * Altera a senha do usuário
	 */
	private void resetSenha(Usuario usuario, String novaSenha) {

		String novaSenhaCripto = SenhaUtil.criptoSenha(novaSenha);

		usuario.setSenha(novaSenhaCripto);
		usuario.setResetSenha(false);
		usuario.setResetSenhaUuid(null);
		usuario.setResetSenhaDataLimite(null);
		usuario.setResetSenhaDataEnvioEmail(null);

		usuarioRepository.save(usuario);

	}
	
	
}
