package com.app.doggi.implementation.service;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.interfaces.mapper.IDogBreedMapperImpl;
import com.app.doggi.interfaces.service.IDogBreedService;
import com.app.doggi.model.Color;
import com.app.doggi.model.DogBreed;
import com.app.doggi.model.Nature;
import com.app.doggi.repository.IColorRespository;
import com.app.doggi.repository.IDogBreedRepository;
import com.app.doggi.repository.INatureRepository;
import com.app.doggi.utils.exceptions.ColorDoesNotExistException;
import com.app.doggi.utils.exceptions.DogBreedDoesNotHaveColorException;
import com.app.doggi.utils.exceptions.DogBreedDoesNotHaveNatureException;
import com.app.doggi.utils.exceptions.NatureDoesNotExistException;
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
    private IColorRespository iColorRespository;
    private INatureRepository iNatureRepository;

    @Autowired
    public DogBreedServiceImpl(IDogBreedRepository iDogBreedRepository, IColorRespository iColorRespository, INatureRepository iNatureRepository){
        this.iDogBreedRepository = iDogBreedRepository;
        this.iColorRespository = iColorRespository;
        this.iNatureRepository = iNatureRepository;
    }

    /**
     * Method that save a new dog breed in the application
     * @param dogBreedStdInDto
     * @return
     */
    @Override
    public DogBreedStdOutDto save(DogBreedStdInDto dogBreedStdInDto) {
        DogBreed dogBreed = IDogBreedMapperImpl.INTANCE.asDogBredToDogBreedStdInDtoToDogBreed(dogBreedStdInDto);

        if(!(dogBreedStdInDto.getDogBreedColors().size() > 0)){
            throw new DogBreedDoesNotHaveColorException("Dog breed must have at least one nested color");
        }else{
            for (Long idColorDogBreed: dogBreedStdInDto.getDogBreedColors()) {
                if(!iColorRespository.existsById(idColorDogBreed)){
                    throw new ColorDoesNotExistException("Color does not exist");
                }else{
                    Color color = iColorRespository.findById(idColorDogBreed).get();
                    dogBreed.addColor(color);
                }
            }
        }
        if(!(dogBreedStdInDto.getDogBreedNatures().size()>0)){
            throw new DogBreedDoesNotHaveNatureException("Dog breed must have at least one nested nature");
        }else{
            for (Long idNatureDogBreed: dogBreedStdInDto.getDogBreedNatures()) {
                if(!iNatureRepository.existsById(idNatureDogBreed)){
                    throw new NatureDoesNotExistException("Nature does not exist");
                }else{
                    Nature nature = iNatureRepository.findById(idNatureDogBreed).get();
                    dogBreed.addNature(nature);
                }

            }
        }

        DogBreedStdOutDto dogBreedStdOutDto = IDogBreedMapperImpl.INTANCE.asDogBredToDogBreedStdOutDto(dogBreed);
        dogBreedStdOutDto.setDogBreedColors(dogBreed.getColors());
        dogBreedStdOutDto.setDogBreedNatures(dogBreed.getNatures());
        iDogBreedRepository.save(dogBreed);
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
