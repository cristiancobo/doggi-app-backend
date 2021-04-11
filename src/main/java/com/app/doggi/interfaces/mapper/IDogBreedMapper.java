package com.app.doggi.interfaces.mapper;

import com.app.doggi.model.DogBreed;
import com.app.doggi.stdin.DogBreedStdInDto;
import com.app.doggi.stdout.DogBreedStdOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface representing an dog-breed's interface mapper
 * @version 1.0
 */
@Mapper
public interface IDogBreedMapper {

    IDogBreedMapper INTANCE = Mappers.getMapper(IDogBreedMapper.class);
    DogBreedStdOutDto asDogBredToDogBreedStdOutDto(DogBreed dogBreed);
    DogBreed asDogBredToDogBreedStdInDtoToDogBreed(DogBreedStdInDto dogBreedStdInDto);

}
