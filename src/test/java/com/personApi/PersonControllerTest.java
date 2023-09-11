package com.personApi;

import com.personApi.controller.PersonController;
import com.personApi.data.dto.PersonRequest;
import com.personApi.data.model.Person;
import com.personApi.data.repo.PersonRepository;
import com.personApi.data.dto.PersonResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class PersonControllerTests {
    @Mock
    private PersonRepository personRepository;

    private PersonController personController;


    @Test
    void contextLoads() {

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personController = new PersonController(personRepository);
    }

    @Test
    void testCreatePerson() {
        // Arrange
        PersonRequest request = new PersonRequest();
        request.setName("John");
        request.setAge(30);

        Person person = new Person();
        person.setId(1L);
        person.setName("John");
        person.setAge(30);

        when(personRepository.save(any(Person.class))).thenReturn(person);

        // Act
        ResponseEntity<?> responseEntity = personController.createPerson(request);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(PersonResponse.class, responseEntity.getBody().getClass());
    }

    @Test
    void testGetPerson() {
        // Arrange
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setName("John");
        person.setAge(30);

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        // Act
        ResponseEntity<?> responseEntity = personController.getPerson(personId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(PersonResponse.class, responseEntity.getBody().getClass());
    }

    @Test
    void testGetPersonNotFound() {
        // Arrange
        Long nonExistentPersonId = 99L;

        when(personRepository.findById(nonExistentPersonId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> responseEntity = personController.getPerson(nonExistentPersonId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testGetAllPersons() {
        // Arrange
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("John");
        person1.setAge(30);
        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Jane");
        person2.setAge(25);
        persons.add(person1);
        persons.add(person2);

        when(personRepository.findAll()).thenReturn(persons);

        // Act
        ResponseEntity<List<?>> responseEntity = personController.getAllPersons();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(ArrayList.class, responseEntity.getBody().getClass());
        assertEquals(PersonResponse.class, ((List<?>) responseEntity.getBody()).get(0).getClass());
        assertEquals(2, ((List<?>) responseEntity.getBody()).size());
    }

    @Test
    void testUpdatePerson() {
        // Arrange
        Long personId = 1L;
        PersonRequest request = new PersonRequest();
        request.setName("UpdatedName");
        request.setAge(35);

        Person existingPerson = new Person();
        existingPerson.setId(personId);
        existingPerson.setName("John");
        existingPerson.setAge(30);

        when(personRepository.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(personRepository.save(any(Person.class))).thenReturn(existingPerson);

        // Act
        ResponseEntity<?> responseEntity = personController.updatePerson(personId, request);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(PersonResponse.class, responseEntity.getBody().getClass());
    }

    @Test
    void testUpdatePersonNotFound() {
        // Arrange
        Long nonExistentPersonId = 99L;
        PersonRequest request = new PersonRequest();
        request.setName("UpdatedName");
        request.setAge(35);

        when(personRepository.findById(nonExistentPersonId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> responseEntity = personController.updatePerson(nonExistentPersonId, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletePerson() {
        // Arrange
        Long personId = 1L;
        Person existingPerson = new Person();
        existingPerson.setId(personId);
        existingPerson.setName("John");
        existingPerson.setAge(30);

        when(personRepository.findById(personId)).thenReturn(Optional.of(existingPerson));

        // Act
        ResponseEntity<?> responseEntity = personController.deletePerson(personId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testDeletePersonNotFound() {
        // Arrange
        Long nonExistentPersonId = 99L;

        when(personRepository.findById(nonExistentPersonId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> responseEntity = personController.deletePerson(nonExistentPersonId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}

