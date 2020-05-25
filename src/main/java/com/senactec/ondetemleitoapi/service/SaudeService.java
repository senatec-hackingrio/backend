package com.senactec.ondetemleitoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senactec.ondetemleitoapi.model.Saude;
import com.senactec.ondetemleitoapi.model.request.FormNovoRegistroSaude;
import com.senactec.ondetemleitoapi.repository.SaudeRepository;

@Service
public class SaudeService {
	
	@Autowired
	SaudeRepository saudeRepository;
	
	public void novoRegistro(FormNovoRegistroSaude formNovoRegistroSaude) {
		
		Saude saude = new Saude();
		saude.setFrequenciaCardiaca(formNovoRegistroSaude.getFrequenciaCardiaca());
		saude.setFrequenciaRespitoria(formNovoRegistroSaude.getFrequenciaRespitatoria());
		saude.setPressaoArterial(formNovoRegistroSaude.getPressaoArterial());
		
		saudeRepository.save(saude);
	}
	
	
	public List<Saude> recuperaTodos(){
		List<Saude> findAll = saudeRepository.findAll();
		return findAll;
	}

}
