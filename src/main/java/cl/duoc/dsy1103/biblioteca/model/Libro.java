package cl.duoc.dsy1103.biblioteca.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, equals y hashCode
@Entity // Define esta clase como una entidad de JPA
@NoArgsConstructor // Genera un constructor sin argumentos requerido por JPA
@AllArgsConstructor // Genera un constructor con argumentos para todos los campos
public class Libro {
    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.UUID) // Genera automáticamente un UUID para el campo id
    private String id;
    private String isbn;
    private String titulo;
    private String editorial;
    private Date fechaPublicacion;
    private String autor;
}
