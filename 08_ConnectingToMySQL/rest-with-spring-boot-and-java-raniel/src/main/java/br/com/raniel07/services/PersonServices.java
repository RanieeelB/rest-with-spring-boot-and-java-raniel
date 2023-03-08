package br.com.raniel07.services;

import br.com.raniel07.exceptions.ResourseNotFoundException;
import br.com.raniel07.model.Person;
import br.com.raniel07.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all people! ");
        return repository.findAll();
        
    }

    public Person create(Person person){
        logger.info("Creating one person! ");
                return repository.save(person);

    }

    public Person update(Person person){
        logger.info("Updating one person! ");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person! ");
        var entity = repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }





    public  Person findById(Long id) {
        logger.info("Finding one person! ");
        return repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID!"));
    }

}
