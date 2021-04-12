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
    public DogBreedStdOutDto save(DogBreedStdInDto dogBreedStdInDto);
    public DogBreedStdOutDto update(Long id, DogBreedStdInDto dogBreedStdInDto);
    public DogBreedStdOutDto delete(Long id);
    public DogBreedStdOutDto findById(Long id);

    public List<DogBreedStdOutDto> findAll();
}
