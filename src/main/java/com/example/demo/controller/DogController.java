package com.example.demo.controller;

import com.example.demo.model.Dog;
import com.example.demo.services.DogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class DogController {
    private DogServiceImpl dogServiceImpl;

    @GetMapping(value = "/alldogs")
    public List<Dog> getAllDogs() {
        return dogServiceImpl.getAllDogs();
    }

    @GetMapping(value = "/alldogs/{id}")
    public Optional<Dog> getOneDogById(@PathVariable("id") Long id) {
        return dogServiceImpl.getDogById(id);
    }

    @GetMapping(value = "/{dogtype}/savedogs/{count}")
    public ResponseEntity<List<Dog>> saveAllDogs(@PathVariable("dogtype") String dogtype, @PathVariable("count") Long count) {
        return dogServiceImpl.saveDogData(dogtype,count);
    }

    @GetMapping(value = "/{dogtype}/saveonedog")
    public ResponseEntity<Dog> getOneDog(@PathVariable("dogtype") String dogtype) {
        return dogServiceImpl.saveOneDogData(dogtype);
    }

    @PutMapping(value = "/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable("id") Long id, @RequestBody Dog dog) {
        return dogServiceImpl.updateDog(id, dog);
    }


}
