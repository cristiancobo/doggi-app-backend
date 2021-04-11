package com.app.doggi.interfaces.mapper;

import com.app.doggi.model.DogBreed;
import com.app.doggi.stdin.DogBreedStdInDto;

public interface IDogBreedService {

    public DogBreed save(DogBreedStdInDto dogBreedStdInDto);
    public DogBreed update(Long id, DogBreedStdInDto dogBreedStdInDto);
    public DogBreed delete(Long id);
    public DogBreed findById(Long id);
}
