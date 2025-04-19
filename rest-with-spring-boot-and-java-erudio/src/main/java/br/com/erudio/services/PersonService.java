package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.models.PersonModel;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;


    public PersonModel findById(Long id) {
        logger.info("Finding one person");

        return personRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No records founds for this ID"));
    }

    public List<PersonModel> findAll() {
        logger.info("Finding all people");

        return personRepository.findAll();
    }

    public PersonModel create(PersonModel person) {
        logger.info("Creating one person");

        return personRepository.save(person);
    }

    public PersonModel update(PersonModel person) {
        logger.info("Updating one person");

        PersonModel entity = personRepository.findById(person.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("No records founds for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        PersonModel entity = personRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No records founds for this ID"));

        personRepository.delete(entity);
    }

}
