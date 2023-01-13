package com.example.demo.services;

import com.example.demo.model.Dog;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DogService {
    public ResponseEntity<List<Dog>> saveDogData(String dogtype, Long count);

    public List<Dog> getAllDogs();

    public Optional<Dog> getDogById(Long id);

    public ResponseEntity<Dog> saveOneDogData(String dogtype);

    public void deleteDog(Long id);


    ResponseEntity<Dog> updateDog(Long id, Dog dog);
}
