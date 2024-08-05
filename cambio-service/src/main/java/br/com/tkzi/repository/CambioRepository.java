package br.com.tkzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Cambio;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Long> {

	
	Cambio findByFromAndTo(String from, String to);
}
