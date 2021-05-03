package com.app.doggi.controller;

import com.app.doggi.DoggiApplication;
import com.app.doggi.controller.dtos.stdin.CountryStdInDto;
import com.app.doggi.controller.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.controller.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.service.interfaces.IDogBreedService;
import com.app.doggi.utils.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

/**
 * Class representing a dog breed's controller
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/dogbreeds")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class DogBreedRestController {

    private IDogBreedService iDogBreedService;
    private RestTemplate restTemplate;

    @Autowired
    public DogBreedRestController(IDogBreedService iDogBreedService, RestTemplate restTemplate) {
        this.iDogBreedService = iDogBreedService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/")
    public ResponseEntity<DogBreedStdOutDto> saveDogBreed(@Valid @RequestBody DogBreedStdInDto dogBreedStdInDto,  BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        Long idCountry = dogBreedStdInDto.getIdCountry();
        String url =  DoggiApplication.API_COUNTRIES_API_BASE_URL +idCountry;
        String countryName =  restTemplate.getForObject(url,CountryStdInDto.class).getName();
        dogBreedStdInDto.setCountry(countryName);
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.save(dogBreedStdInDto);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto, HttpStatus.CREATED);
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
    @PutMapping("/{id}")
    public ResponseEntity<DogBreedStdOutDto> updateDogBreedById(@PathVariable Long id, @Valid @RequestBody DogBreedStdInDto dogBreedStdInDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        DogBreedStdOutDto dogBreedStdOutDto = iDogBreedService.update(id, dogBreedStdInDto);
        return new ResponseEntity<DogBreedStdOutDto>(dogBreedStdOutDto,HttpStatus.OK);

    }


}
