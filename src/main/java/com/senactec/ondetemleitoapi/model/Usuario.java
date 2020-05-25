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
    private String nomeCompleto;
    
    @Column(unique=true)
    private String cpf;
    
    private String senhaAcesso;
    private String email;
    private String telefone;
    private String endereco;
    private String complemento;
    private String cep;


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


	public String getNomeCompleto() {return nomeCompleto;	}
	public void setNomeCompleto(String nomeCompleto) {this.nomeCompleto = nomeCompleto;	}
	
	public String getCpf() {return cpf;	}
	public void setCpf(String cpf) {this.cpf = cpf;	}
	
	public String getSenhaAcesso() {return senhaAcesso;	}
	public void setSenhaAcesso(String senhaAcesso) {this.senhaAcesso = senhaAcesso;	}
	
	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}
	
	public String getTelefone() {return telefone;	}
	public void setTelefone(String telefone) {this.telefone = telefone;	}
	
	public String getEndereco() {return endereco;}
	public void setEndereco(String endereco) {this.endereco = endereco;	}
	
	public String getComplemento() {return complemento;	}
	public void setComplemento(String complemento) {this.complemento = complemento;	}
	
	public String getCep() {return cep;	}
	public void setCep(String cep) {this.cep = cep;	}
	
	public void setEnabled(boolean enabled) {	this.enabled = enabled;	}
	
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
	public String getPassword() {return this.senhaAcesso;	}

	@Override
	public String getUsername() {return this.cpf;	}

	@Override
	public boolean isAccountNonExpired() {return true;	}

	@Override
	public boolean isAccountNonLocked() {return true;	}

	@Override
	public boolean isCredentialsNonExpired() {return true;	}

	@Override
	public boolean isEnabled() { return true;}

}
