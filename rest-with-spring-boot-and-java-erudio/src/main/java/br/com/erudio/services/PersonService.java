package br.com.erudio.services;

import br.com.erudio.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonModel findById(String id) {
        logger.info("Finding one person");

        PersonModel personModel = new PersonModel();
        personModel.setId(counter.incrementAndGet());
        personModel.setFirstName("João");
        personModel.setLastName("Otávio");
        personModel.setAddress("Recife - Pernambuco - Brasil");
        personModel.setGender("Male");

        return personModel;
    }

    public List<PersonModel> findAll() {
        logger.info("Finding all people");

        List<PersonModel> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonModel personMock = mockPerson(i);
            persons.add(personMock);
        }

        return persons;
    }

    public PersonModel create(PersonModel person) {
        logger.info("Creating one person");

        return person;
    }

    public PersonModel update(PersonModel person) {
        logger.info("Updating one person");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person");
    }

    private PersonModel mockPerson(int i) {

        PersonModel personModel = new PersonModel();
        personModel.setId(counter.incrementAndGet());
        personModel.setFirstName("First name: " + i);
        personModel.setLastName("Lastname: " + i);
        personModel.setAddress("Somewhere in Brazil");
        personModel.setGender("Male");

        return personModel;
    }
}
