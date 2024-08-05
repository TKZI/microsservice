package br.com.tkzi.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
