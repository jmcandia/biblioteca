package cl.duoc.dsy1103.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.dsy1103.biblioteca.model.Libro;

@Repository // Indica que esta interfaz es un repositorio de Spring Data JPA
public interface LibroRepository extends CrudRepository<Libro, String> {
    // Al extender CrudRepository, esta interfaz hereda métodos para realizar
    // operaciones CRUD (Create, Read, Update, Delete) en la entidad Libro.

    Optional<Libro> findByIsbn(String isbn); // Método personalizado para buscar un libro por su ISBN
}
