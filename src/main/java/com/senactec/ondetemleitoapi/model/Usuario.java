package com.senactec.ondetemleitoapi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1905122041950251207L;
	
	// --------------------
	// DADOS USUÁRIO
	// --------------------
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	private String email;
	
	
	private String login;
	
	
	private String senha;

	@Column(name = "data_ultimo_login")
	private LocalDateTime dataUltimoLogin;

	
	// --------------------
	// DADOS RESET DE SENHA
	// --------------------
	@Column(name = "reset_senha", columnDefinition = "boolean default false")
	private boolean resetSenha;
	
	@Column(name = "reset_senha_uuid")
	private String resetSenhaUuid;
	
	@Column(name = "reset_senha_envio_email")
	private LocalDateTime resetSenhaDataEnvioEmail;
	
	@Column(name = "reset_senha_data_limite")
	private LocalDateTime resetSenhaDataLimite;
	
	
	// ----------------------
	// DADOS spring security
	// ----------------------
	@Column(name = "ENABLED", columnDefinition = "TINYINT DEFAULT 1")
	private boolean enabled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id", referencedColumnName = "id")
	private Perfil perfil;

	
	
	
	
	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;	}

	public String getNome() {return nome;	}
	public void setNome(String nome) {this.nome = nome;	}

	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	public String getLogin() {return login;	}
	public void setLogin(String login) {this.login = login;	}

	public String getSenha() {return senha;	}
	public void setSenha(String senha) {this.senha = senha;	}

	public LocalDateTime getDataUltimoLogin() {	return dataUltimoLogin;	}
	public void setDataUltimoLogin(LocalDateTime dataUltimoLogin) {	this.dataUltimoLogin = dataUltimoLogin;	}

	public boolean isResetSenha() { return resetSenha;}
	public void setResetSenha(boolean resetSenha) {	this.resetSenha = resetSenha;	}

	public String getResetSenhaUuid() {	return resetSenhaUuid;	}
	public void setResetSenhaUuid(String resetSenhaUuid) {	this.resetSenhaUuid = resetSenhaUuid;	}

	public LocalDateTime getResetSenhaDataEnvioEmail() {return resetSenhaDataEnvioEmail;	}
	public void setResetSenhaDataEnvioEmail(LocalDateTime resetSenhaDataEnvioEmail) {this.resetSenhaDataEnvioEmail = resetSenhaDataEnvioEmail;	}

	public LocalDateTime getResetSenhaDataLimite() {return resetSenhaDataLimite;	}
	public void setResetSenhaDataLimite(LocalDateTime resetSenhaDataLimite) {this.resetSenhaDataLimite = resetSenhaDataLimite;	}

	public Perfil getPerfil() {	return perfil;	}
	public void setPerfil(Perfil perfil) {	this.perfil = perfil;	}

	
	/*
	 * METODOS PARA SPRING SECURITY
	 */
	public void setEnabled() {
		this.enabled = true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Perfil> perfis = new ArrayList<>();
		perfis.add(this.perfil);
		
		return perfis;		
	}

	
	@Override
	public String getPassword() {return this.senha;	}

	@Override
	public String getUsername() {return this.login;	}

	@Override
	public boolean isAccountNonExpired() {return true;	}

	@Override
	public boolean isAccountNonLocked() {return true;	}

	@Override
	public boolean isCredentialsNonExpired() {return true;	}

	@Override
	public boolean isEnabled() { return true;}

}
