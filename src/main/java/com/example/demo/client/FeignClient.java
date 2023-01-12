package com.example.demo.client;

import com.example.demo.dto.DogData;
import com.example.demo.model.Dog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(value = "Dog-API", url = "https://dog.ceo/api/breed/hound/images/random")
public interface FeignClient {

//    @GetMapping(value = "/{dogsort}/images/random")
//    DogData getOneDog(@RequestParam("dogsort") String dogsort);

    //    @GetMapping(value = "/{dogsort}/images/random/{count}")
//    DogData getDogData(@RequestParam("dogsort") String dogsort, @RequestParam("count") Long count);
//    @GetMapping(value = "/{dogsort}/images/random/{count}")
    @GetMapping(value = "/3")
    DogData getDogData();

    @GetMapping(value = "")
    Dog oneDogData();

}
