package com.senactec.ondetemleitoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saude {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String pressaoArterial;
    private String frequenciaCardiaca;
    private String frequenciaRespitoria;
    
    
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	
	public String getPressaoArterial() {	return pressaoArterial;	}
	public void setPressaoArterial(String pressaoArterial) {	this.pressaoArterial = pressaoArterial;	}
	
	public String getFrequenciaCardiaca() {	return frequenciaCardiaca;	}
	public void setFrequenciaCardiaca(String frequenciaCardiaca) {	this.frequenciaCardiaca = frequenciaCardiaca;	}
	
	public String getFrequenciaRespitoria() {	return frequenciaRespitoria;	}
	public void setFrequenciaRespitoria(String frequenciaRespitoria) {	this.frequenciaRespitoria = frequenciaRespitoria;	}
    
    
}
