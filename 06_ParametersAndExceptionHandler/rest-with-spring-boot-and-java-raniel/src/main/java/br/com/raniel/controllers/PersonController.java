package br.com.raniel.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.raniel.converters.NumberConverter;
import br.com.raniel.exceptions.UnsupportedMathOperationException;
import br.com.raniel.math.SimpleMath;
import br.com.raniel.model.Person;
import br.com.raniel.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {


	@Autowired
	private PersonServices service = new PersonServices();
    //private PersonServices service = new PersonServices();




	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findByID(@PathVariable(value = "id") String id) throws Exception{
		return service.findById(id);
	}
}
