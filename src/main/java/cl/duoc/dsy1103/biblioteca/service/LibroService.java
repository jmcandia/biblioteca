package cl.duoc.dsy1103.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.dsy1103.biblioteca.exception.NotFoundException;
import cl.duoc.dsy1103.biblioteca.model.Libro;
import cl.duoc.dsy1103.biblioteca.repository.LibroRepository;

@Service // Indica que esta clase es un servicio de Spring, lo que permite su inyección en otros componentes
public class LibroService {

    @Autowired // Inyecta automáticamente una instancia de LibroRepository en esta clase
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros() {
        // Devuelve una lista de todos los libros en la base de datos
        return (List<Libro>) libroRepository.findAll();
    }

    public Libro getLibroById(String id) {
        // Busca un libro por su ID y devuelve null si no se encuentra
        // UPDATE: Cambiado para lanzar una excepción si el libro no se encuentra, en lugar de devolver null
        return libroRepository.findById(id).orElseThrow(() -> new NotFoundException("Libro no encontrado con ID: " + id));
    }

    public Libro getLibroByIsbn(String isbn) {
        // Busca un libro por su ISBN utilizando el método personalizado
        // del repositorio y devuelve null si no se encuentra
        // UPDATE: Cambiado para lanzar una excepción si el libro no se encuentra, en lugar de devolver null
        return libroRepository.findByIsbn(isbn).orElseThrow(() -> new NotFoundException("Libro no encontrado con ISBN: " + isbn));
    }

    public Libro addLibro(Libro libro) {
        // Guarda un nuevo libro o actualiza uno existente en la base de datos
        return libroRepository.save(libro);
    }

    public Libro updateLibro(String id, Libro libro) {
        // UPDATE: Cambiado para verificar si el libro existe antes de intentar actualizarlo, y lanzar una excepción si no se encuentra
        // Actualiza un libro existente si se encuentra por su ID
        if (!libroRepository.existsById(id)) {
            // Lanza una excepción si el libro no se encuentra para actualizar
            throw new NotFoundException("Libro no encontrado con ID: " + id);
        }
        libro.setId(id); // Asegura que el ID del libro a actualizar se mantenga igual
        return libroRepository.save(libro); // Guarda el libro actualizado
    }

    public void deleteLibro(String id) {
        // UPDATE: Cambiado para verificar si el libro existe antes de intentar eliminarlo, y lanzar una excepción si no se encuentra
        // Elimina un libro por su ID si existe en la base de datos
        if (!libroRepository.existsById(id)) {
            // Lanza una excepción si el libro no se encuentra para eliminar
            throw new NotFoundException("Libro no encontrado con ID: " + id);
        }
        libroRepository.deleteById(id); // Elimina el libro
    }
}
