package cl.duoc.dsy1103.biblioteca;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.duoc.dsy1103.biblioteca.model.Libro;
import cl.duoc.dsy1103.biblioteca.repository.LibroRepository;

@SpringBootApplication
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(LibroRepository libroRepository) {
        return (args) -> {
            // Agregamos null al principio para el campo 'id'
            libroRepository.save(new Libro(null, "978-0-13-468599-1", "Effective Java", "Addison-Wesley", new Date(), "Joshua Bloch"));
            libroRepository.save(new Libro(null, "978-0-59-600920-5", "Head First Design Patterns", "O'Reilly Media", new Date(), "Eric Freeman"));
            libroRepository.save(new Libro(null, "978-1-491-94728-5", "Spring in Action", "Manning Publications", new Date(), "Craig Walls"));
            libroRepository.save(new Libro(null, "978-1-59327-584-6", "Automate the Boring Stuff with Python", "No Starch Press", new Date(), "Al Sweigart"));
        };
    }
}
