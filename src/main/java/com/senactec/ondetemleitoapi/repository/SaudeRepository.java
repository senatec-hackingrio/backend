package com.senactec.ondetemleitoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senactec.ondetemleitoapi.model.Saude;
import com.senactec.ondetemleitoapi.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaudeRepository extends JpaRepository<Saude, Long> {
	
	
}
