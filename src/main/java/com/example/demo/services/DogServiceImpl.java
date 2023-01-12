package com.example.demo.services;

import com.example.demo.client.FeignClient;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;
    private FeignClient dogClient;

    @Override
    public ResponseEntity<List<Dog>> saveDogData() {
        List<String> dogDataMessage = dogClient.getDogData().getMessage();
        List<Dog> dogs = new ArrayList<>();
        for (String message : dogDataMessage) {
            Dog dog = new Dog();
            dog.setMessage(message);
            dog.setStatus(dogClient.getDogData().getStatus());
            dogs.add(dogRepository.save(dog));
        }
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dog> saveOneDogData() {
        Dog dog = dogClient.oneDogData();

        dogRepository.save(dog);
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }


    @Override
    public ResponseEntity<Dog> updateDog(Long id, Dog dog) {
        Dog currentDog = dogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dog not found with id " + id));
//        if(!dog.getMessage().isEmpty()){
//
//        }
        currentDog.setMessage(dog.getMessage());
        currentDog.setStatus(dog.getStatus());
        return new ResponseEntity<>(dogRepository.save(currentDog), HttpStatus.OK);
    }
}
