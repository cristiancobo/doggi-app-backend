package com.app.doggi.implementation.service;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.interfaces.service.IDogBreedService;
import com.app.doggi.model.DogBreed;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class representing dog breed service implementation.
 * @version 1.0
 */
@Service
public class DogBreedServiceImpl implements IDogBreedService {

    @Override
    public DogBreed save(DogBreedStdInDto dogBreedStdInDto) {
        return null;
    }

    @Override
    public DogBreed update(Long id, DogBreedStdInDto dogBreedStdInDto) {
        return null;
    }

    @Override
    public DogBreed delete(Long id) {
        return null;
    }

    @Override
    public DogBreed findById(Long id) {
        return null;
    }

    @Override
    public List<DogBreedStdOutDto> findAll() {
        return null;
    }
}
