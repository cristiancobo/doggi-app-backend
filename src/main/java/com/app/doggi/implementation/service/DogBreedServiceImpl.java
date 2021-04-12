package com.app.doggi.implementation.service;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.interfaces.mapper.IDogBreedMapperImpl;
import com.app.doggi.interfaces.service.IDogBreedService;
import com.app.doggi.model.DogBreed;
import com.app.doggi.repository.IDogBreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class representing dog breed service implementation.
 * @version 1.0
 */
@Service
public class DogBreedServiceImpl implements IDogBreedService {

    private IDogBreedRepository iDogBreedRepository;

    @Autowired
    public DogBreedServiceImpl(IDogBreedRepository iDogBreedRepository){
        this.iDogBreedRepository = iDogBreedRepository;
    }

    /**
     * Method that save a new dog breed in the application
     * @param dogBreedStdInDto
     * @return
     */
    @Override
    public DogBreedStdOutDto save(DogBreedStdInDto dogBreedStdInDto) {
        DogBreed dogBreed = IDogBreedMapperImpl.INTANCE.asDogBredToDogBreedStdInDtoToDogBreed(dogBreedStdInDto);
        dogBreed.setColors(dogBreedStdInDto.getDogBreedColors());
        dogBreed.setNatures(dogBreedStdInDto.getDogBreedNatures());
        DogBreedStdOutDto dogBreedStdOutDto = IDogBreedMapperImpl.INTANCE.asDogBredToDogBreedStdOutDto(dogBreed);
        dogBreedStdOutDto.setDogBreedColors(dogBreed.getColors());
        dogBreedStdOutDto.setDogBreedNatures(dogBreed.getNatures());
        return dogBreedStdOutDto;
    }

    @Override
    public DogBreedStdOutDto update(Long id, DogBreedStdInDto dogBreedStdInDto) {
        return null;
    }

    @Override
    public DogBreedStdOutDto delete(Long id) {
        return null;
    }

    @Override
    public DogBreedStdOutDto findById(Long id) {
        return null;
    }

    @Override
    public List<DogBreedStdOutDto> findAll() {
        return null;
    }
}
