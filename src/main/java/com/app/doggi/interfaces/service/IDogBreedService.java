package com.app.doggi.interfaces.service;


import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.model.DogBreed;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface representing dog breed interface service.
 * @version 1.0
 */
@Service
public interface IDogBreedService {
    public DogBreed save(DogBreedStdInDto dogBreedStdInDto);
    public DogBreed update(Long id, DogBreedStdInDto dogBreedStdInDto);
    public DogBreed delete(Long id);
    public DogBreed findById(Long id);
    public List<DogBreedStdOutDto> findAll();
}
