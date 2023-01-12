package com.example.demo.services;

import com.example.demo.model.Dog;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DogService {
    public ResponseEntity<List<Dog>> saveDogData();

    public List<Dog> getAllDogs();

    public Optional<Dog> getDogById(Long id);

    public ResponseEntity<Dog> saveOneDogData();




    ResponseEntity<Dog> updateDog(Long id, Dog dog);
}
