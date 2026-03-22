package cl.duoc.dsy1103.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.dsy1103.biblioteca.model.Libro;
import cl.duoc.dsy1103.biblioteca.service.LibroService;

@RestController // Indica que esta clase es un controlador REST de Spring
@RequestMapping("/api/libros") // Define la ruta base para todas las solicitudes relacionadas con libros
public class LibroController {
    @Autowired // Inyecta automáticamente una instancia de LibroService en esta clase
    private LibroService libroService;

    // Endpoint para listar todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        // Llama al servicio para obtener todos los libros
        return libroService.getAllLibros();
    }
    
    // Endpoint para obtener un libro por su ID
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable String id) {
        // Llama al servicio para obtener un libro por su ID
        return libroService.getLibroById(id);
    }

    // Endpoint para obtener un libro por su ISBN
    @GetMapping("/isbn/{isbn}")
    public Libro getLibroByIsbn(@PathVariable String isbn) {
        // Llama al servicio para obtener un libro por su ISBN
        return libroService.getLibroByIsbn(isbn);
    }

    // Endpoint para agregar un nuevo libro
    @PostMapping
    public Libro addLibro(@RequestBody Libro libro) {
        // Llama al servicio para agregar un nuevo libro
        return libroService.addLibro(libro);
    }

    // Endpoint para actualizar un libro existente
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable String id, @RequestBody Libro libro) {
        // Llama al servicio para actualizar un libro existente
        return libroService.updateLibro(id, libro);
    }

    // Endpoint para eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable String id) {
        // Llama al servicio para eliminar un libro por su ID
        libroService.deleteLibro(id);
    }
}
