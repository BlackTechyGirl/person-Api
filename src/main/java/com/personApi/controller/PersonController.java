package com.personApi.controller;

import com.personApi.data.dto.PersonRequest;
import com.personApi.data.dto.PersonResponse;
import com.personApi.data.model.Person;
import com.personApi.data.repo.PersonRepository;
import com.personApi.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody PersonRequest request) {
        try {
            if (request.getName() == null || request.getName().isEmpty()) {
                return ResponseEntity.badRequest().body("Name is required.");
            }

            Person person = new Person();
            person.setName(request.getName());
            person.setAge(request.getAge());

            Person savedPerson = personRepository.save(person);
            PersonResponse response = new PersonResponse();
            response.setId(savedPerson.getId());
            response.setName(savedPerson.getName());
            response.setAge(savedPerson.getAge());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        try {
            Optional<Person> person = personRepository.findById(id);

            if (person.isPresent()) {
                PersonResponse response = new PersonResponse();
                response.setId(person.get().getId());
                response.setName(person.get().getName());
                response.setAge(person.get().getAge());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }



    @GetMapping
    public ResponseEntity<List<?>> getAllPersons() {
        try {
            List<Person> persons = personRepository.findAll();

            List<PersonResponse> responseList = persons.stream()
                    .map(person -> {
                        PersonResponse response = new PersonResponse();
                        response.setId(person.getId());
                        response.setName(person.getName());
                        response.setAge(person.getAge());

                        return response;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responseList);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody PersonRequest request) {
        try {
            Optional<Person> existingPerson = personRepository.findById(id);

            if (existingPerson.isPresent()) {
                Person personToUpdate = existingPerson.get();
                personToUpdate.setName(request.getName());
                personToUpdate.setAge(request.getAge());

                Person updated = personRepository.save(personToUpdate);

                PersonResponse response = new PersonResponse();
                response.setId(updated.getId());
                response.setName(updated.getName());
                response.setAge(updated.getAge());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        try {
            Optional<Person> person = personRepository.findById(id);

            if (person.isPresent()) {
                personRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

}
