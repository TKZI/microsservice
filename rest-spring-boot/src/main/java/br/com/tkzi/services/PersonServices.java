package br.com.tkzi.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tkzi.exeption.ResourceNotFoundException;
import br.com.tkzi.model.Person;
import br.com.tkzi.repositores.PersonRepository;


@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository repository;
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	
	public List<Person> findAll(){
		logger.info("finding all people");
		return repository.findAll();
	}

	
	


	public Person findById(Long id) {
		logger.info("finding one person");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException
				("No records found for this ID"));
	}
	
	public Person create(Person person) {
		logger.info("creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("updating one person!");
	var entity = 	repository.findById(person.getId()).orElseThrow(() ->new ResourceNotFoundException
				("No records found for this ID") );
	
	entity.setFirstName(person.getFirstName());
	entity.setLastName(person.getLastName());
	entity.setAddress(person.getAddress());
	entity.setGender(person.getGender());
	
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException
				("No records found for this ID"));
		repository.delete(entity);
	}
}
