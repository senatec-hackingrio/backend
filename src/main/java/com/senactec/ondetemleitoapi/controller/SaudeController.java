package com.senactec.ondetemleitoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senactec.ondetemleitoapi.model.Saude;
import com.senactec.ondetemleitoapi.model.request.FormNovoRegistroSaude;
import com.senactec.ondetemleitoapi.service.SaudeService;

@RestController
@RequestMapping("/saude")
public class SaudeController {
	
	@Autowired
	SaudeService saudeService;

	@PostMapping
	public void novoRegistro(@RequestBody FormNovoRegistroSaude form, @AuthenticationPrincipal UserDetails userDetails) {
		saudeService.novoRegistro(form);
	}
	
	
	@GetMapping
	public List<Saude> recuperaTodos(@AuthenticationPrincipal UserDetails userDetails){
		return saudeService.recuperaTodos();
	}
}
