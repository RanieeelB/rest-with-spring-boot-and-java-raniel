package br.com.raniel07.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ResourseNotFoundException(String ex){
        super(ex);
    }



}
