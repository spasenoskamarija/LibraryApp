package mk.ukim.finki.emt2025.lab1.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException(Long id) {
        super(String.format("Manufacturer with id: %d was not found", id));
    }
}
