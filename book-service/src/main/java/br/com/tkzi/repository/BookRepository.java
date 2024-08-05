package br.com.tkzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
