package com.app.doggi.interfaces.mapper;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.model.DogBreed;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDogBreedMapper {
    IDogBreedMapper INTANCE = Mappers.getMapper(IDogBreedMapper.class);
    DogBreedStdOutDto asDogBredToDogBreedStdOutDto(DogBreed dogBreed);
    DogBreed asDogBredToDogBreedStdInDtoToDogBreed(DogBreedStdInDto dogBreedStdInDto);


}
