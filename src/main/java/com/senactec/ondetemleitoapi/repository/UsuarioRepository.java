package com.senactec.ondetemleitoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senactec.ondetemleitoapi.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	/**
	 * Prequisa o usuário pelo login de acesso e retorna um objeto Optional<Usuário>
	 */
    Optional<Usuario> findByLogin(String login);

    /**
	 * Prequisa o usuário pelo email cadastrado e retorna um objeto Optional<Usuário>
	 */
    Optional<Usuario> findUsuarioByEmail(String email);
    
    /**
	 * Pesquisa se existe algum usuário, que tenha solicitdo o reset com o UUID informado e que ainda não tenha ispirado (cada UUID tem um tempo vida)
	 */
    Optional<Usuario> findByResetSenhaUuidAndResetSenhaDataLimiteGreaterThanEqual(String resetSenhaUuid,LocalDateTime resetSenhaDataLimite);
    
    /**
	 * Pesquisa os usuários que estão cadasdtrados, porem não acessam p sistema a um tempo
	 */
    List<Usuario> findByDataUltimoLoginLessThanEqual(LocalDateTime dataUltimoLogin);
    
    /**
     * Retorna os usuários que solicitaram o reset de senha
     */
    @Query(value = "SELECT u FROM Usuario u WHERE u.resetSenha = 1 and u.resetSenhaDataEnvioEmail is null")
    List<Usuario> findUsuariosResetSenha();

}
