package com.example.demo.client;

import com.example.demo.dto.DogData;
import com.example.demo.model.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@org.springframework.cloud.openfeign.FeignClient(value = "Dog-API", url = "https://dog.ceo/api/breed")
public interface FeignClient {

    @GetMapping(value = "/{dogtype}/images/random/{count}")
    DogData getDogData(@PathVariable("dogtype") String dogtype, @PathVariable("count") Long count);

    @GetMapping(value = "/{dogtype}/images/random")
    Dog oneDogData(@PathVariable("dogtype") String dogtype);

}
