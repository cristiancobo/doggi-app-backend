package com.app.doggi.service.mapper;

import com.app.doggi.controller.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.controller.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.model.DogBreed;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IDogBreedMapper {
    IDogBreedMapper INTANCE = Mappers.getMapper(IDogBreedMapper.class);
    DogBreedStdOutDto asDogBredToDogBreedStdOutDto(DogBreed dogBreed);
    DogBreed asDogBredToDogBreedStdInDtoToDogBreed(DogBreedStdInDto dogBreedStdInDto);
    List<DogBreedStdOutDto> asListDogBreedEntitiesToListDogBreedStdInDto(List<DogBreed> dogBreeds);


}
