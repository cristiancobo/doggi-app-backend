package com.app.doggi.restcontroller;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.interfaces.service.IDogBreedService;
import com.app.doggi.utils.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Class representing a dog breed's controller
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/dogbreeds")
public class DogBreedRestController {

    private IDogBreedService iDogBreedService;

    @Autowired
    public DogBreedRestController(IDogBreedService iDogBreedService){
        this.iDogBreedService = iDogBreedService;
    }

    @PostMapping("/")
    public ResponseEntity<DogBreedStdOutDto> saveDogBreed(@Valid @RequestBody DogBreedStdInDto dogBreedStdInDto,  BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.save(dogBreedStdInDto);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DogBreedStdOutDto> findByIdDogBreed(@PathVariable Long id){
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.findById(id);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<DogBreedStdOutDto>> findAllDogBreeds(){
        List<DogBreedStdOutDto> dogBreedStdOutDtos = iDogBreedService.findAll();
        return new ResponseEntity<List<DogBreedStdOutDto>>(dogBreedStdOutDtos, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DogBreedStdOutDto> deleteDogBreedById(@PathVariable Long id){
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.delete(id);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto,HttpStatus.OK);

    }


}
