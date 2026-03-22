package cl.duoc.dsy1103.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Indica que esta excepción corresponde a un error 404 Not Found
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        // Constructor sin argumentos que llama al constructor de la clase padre RuntimeException
        super();
    }

    public NotFoundException(String message) {
        // Llama al constructor de la clase padre RuntimeException con el mensaje de error
        super(message); 
    }
}
