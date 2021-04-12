package com.app.doggi.restcontroller;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.interfaces.service.IDogBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class representing a dog breed's controller
 * @version 1.0
 */
@RestController
@RequestMapping("dogbreed")
public class DogBreedRestController {

    private IDogBreedService iDogBreedService;

    @Autowired
    public DogBreedRestController(IDogBreedService iDogBreedService){
        this.iDogBreedService = iDogBreedService;
    }

    @PostMapping("/")
    public ResponseEntity<DogBreedStdOutDto> saveDogBreed(@RequestBody DogBreedStdInDto dogBreedStdInDto){
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.save(dogBreedStdInDto);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto, HttpStatus.OK);
    }


}
