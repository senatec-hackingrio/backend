package com.senactec.ondetemleitoapi.model.request;

import com.senactec.ondetemleitoapi.model.Perfil;
import com.senactec.ondetemleitoapi.model.Usuario;
import com.senactec.ondetemleitoapi.util.SenhaUtil;

public class FormCadastroUsuarioRequest {

    private String nomeCompleto;
    private String cpf;
    private String senhaAcesso;
    private String email;
    private String telefone;
    private String endereco;
    private String complemento;
    private String cep;
    
    
	public String getNomeCompleto() {return nomeCompleto;}
	public void setNomeCompleto(String nomeCompleto) {this.nomeCompleto = nomeCompleto;	}

	public String getCpf() {return cpf;	}
	public void setCpf(String cpf) {this.cpf = cpf;	}

	public String getSenhaAcesso() {return senhaAcesso;	}
	public void setSenhaAcesso(String senhaAcesso) {this.senhaAcesso = senhaAcesso;	}

	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;	}

	public String getEndereco() {return endereco;}
	public void setEndereco(String endereco) {this.endereco = endereco;	}

	public String getComplemento() {return complemento;}
	public void setComplemento(String complemento) {this.complemento = complemento;	}

	public String getCep() {return cep;	}
	public void setCep(String cep) {this.cep = cep;	}


	public Usuario converte() {

		Usuario usuario = new Usuario();
		usuario.setNomeCompleto(nomeCompleto);
		usuario.setCpf(cpf);
		usuario.setSenhaAcesso(senhaAcesso);
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
		usuario.setComplemento(complemento);
		usuario.setCep(cep);
		usuario.setEndereco(endereco);
		usuario.setSenhaAcesso(SenhaUtil.criptoSenha(senhaAcesso));
		usuario.setPerfil(new Perfil(1L));
		
		return usuario;
	}
	
}
