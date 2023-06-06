package es.iesrafaelalberti.proyectospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotExistsException extends RuntimeException {
    public CourseNotExistsException(){

    }
    public CourseNotExistsException(String message){
        super(message);
    }
    public CourseNotExistsException(String message, Throwable cause){
        super(message, cause);
    }
    public CourseNotExistsException(Throwable cause){
        super(cause);
    }
}
