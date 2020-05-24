package com.senactec.ondetemleitoapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtil {
	
	private SenhaUtil() {}
	
	/**
	 * Retorna a senha criptografada 
	 * @param senha
	 * @return
	 */
	public static String criptoSenha (String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}
	
	
	/**
	 * Retorna o encode utilizado para a criptografia
	 * @return
	 */
	public static BCryptPasswordEncoder getEnconde() {
		return new BCryptPasswordEncoder();
	}

}
