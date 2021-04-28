package com.app.doggi.implementation.service;

import com.app.doggi.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.model.Color;
import com.app.doggi.model.DogBreed;
import com.app.doggi.model.Nature;
import com.app.doggi.repository.IColorRespository;
import com.app.doggi.repository.IDogBreedRepository;
import com.app.doggi.repository.INatureRepository;
import com.app.doggi.utils.exceptionhandler.ErrorResponse;
import com.app.doggi.utils.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DogBreedServiceImplTest {

    @Mock
    private IDogBreedRepository iDogBreedRepository;
    @Mock
    private IColorRespository iColorRespository;
    @Mock
    INatureRepository iNatureRepository;


    @InjectMocks
    private DogBreedServiceImpl dogBreedService;

    private DogBreedStdInDto dogBreedStdInDto1;
    private DogBreedStdInDto dogBreedStdInDto2;
    private DogBreedStdInDto dogBreedStdInDto3;
    private DogBreedStdInDto dogBreedStdInDto4;
    private DogBreedStdInDto dogBreedStdInDto5;
    private DogBreedStdInDto dogBreedStdInDto6;
    private DogBreedStdInDto dogBreedStdInDto7;
    private DogBreedStdInDto dogBreedStdInDto8;
    private DogBreedStdInDto dogBreedStdInDto9;


    private DogBreed dogBreed;
    private Color color;
    private Nature nature;
    private List<Color> colors;
    private List<Nature> natures;

    @BeforeEach
    public void setUp() {

        color = new Color();
        color.setId(1L);
        color.setName("gold");

        nature = new Nature();
        nature.setId(1L);
        nature.setName("intelligent");

        colors = new ArrayList<Color>();
        colors.add(color);
        natures = new ArrayList<Nature>();
        natures.add(nature);

        dogBreed = new DogBreed();
        dogBreed.setId(1L);
        dogBreed.setName("poddle");
        dogBreed.setHeight(40);
        dogBreed.setWeight(50);
        dogBreed.setCountry("germany");
        dogBreed.setLifeExpectancy(5);
        dogBreed.setColors(colors);
        dogBreed.setNatures(natures);

        dogBreedStdInDto1 = new DogBreedStdInDto();
        dogBreedStdInDto1.setName("pitbull");
        dogBreedStdInDto1.setHeight(40.0);
        dogBreedStdInDto1.setWeight(37.5);
        dogBreedStdInDto1.setLifeExpectancy(10);
        dogBreedStdInDto1.setIdCountry(1L);
        dogBreedStdInDto1.setCountry("united states");
        List<Long> idColorsDogBreed1 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed1 = new ArrayList<Long>();
        idColorsDogBreed1.add(1L);
        idNaturesDogBreed1.add(1L);
        dogBreedStdInDto1.setDogBreedColors(idColorsDogBreed1);
        dogBreedStdInDto1.setDogBreedNatures(idNaturesDogBreed1);

        dogBreedStdInDto2 = new DogBreedStdInDto();
        dogBreedStdInDto2.setHeight(40.0);
        dogBreedStdInDto2.setWeight(37.5);
        dogBreedStdInDto2.setLifeExpectancy(10);
        dogBreedStdInDto2.setIdCountry(1L);
        dogBreedStdInDto2.setCountry("united states");
        List<Long> idColorsDogBreed2 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed2 = new ArrayList<Long>();
        idColorsDogBreed2.add(1L);
        idNaturesDogBreed2.add(1L);
        dogBreedStdInDto2.setDogBreedColors(idColorsDogBreed2);
        dogBreedStdInDto2.setDogBreedNatures(idNaturesDogBreed2);

        dogBreedStdInDto3 = new DogBreedStdInDto();
        dogBreedStdInDto3.setName("pitbull");
        dogBreedStdInDto3.setWeight(37.5);
        dogBreedStdInDto3.setLifeExpectancy(10);
        dogBreedStdInDto3.setIdCountry(1L);
        dogBreedStdInDto3.setCountry("united states");
        List<Long> idColorsDogBreed3 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed3 = new ArrayList<Long>();
        idColorsDogBreed3.add(1L);
        idNaturesDogBreed3.add(1L);
        dogBreedStdInDto3.setDogBreedColors(idColorsDogBreed3);
        dogBreedStdInDto3.setDogBreedNatures(idNaturesDogBreed3);

        dogBreedStdInDto4 = new DogBreedStdInDto();
        dogBreedStdInDto4.setName("pitbull");
        dogBreedStdInDto4.setHeight(40.0);
        dogBreedStdInDto4.setLifeExpectancy(10);
        dogBreedStdInDto4.setIdCountry(1L);
        dogBreedStdInDto4.setCountry("united states");
        List<Long> idColorsDogBreed4 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed4 = new ArrayList<Long>();
        idColorsDogBreed4.add(1L);
        idNaturesDogBreed4.add(1L);
        dogBreedStdInDto4.setDogBreedColors(idColorsDogBreed4);
        dogBreedStdInDto4.setDogBreedNatures(idNaturesDogBreed4);

        dogBreedStdInDto5 = new DogBreedStdInDto();
        dogBreedStdInDto5.setName("pitbull");
        dogBreedStdInDto5.setHeight(40.0);
        dogBreedStdInDto5.setWeight(37.5);
        dogBreedStdInDto5.setIdCountry(1L);
        dogBreedStdInDto5.setCountry("united states");
        List<Long> idColorsDogBreed5 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed5 = new ArrayList<Long>();
        idColorsDogBreed5.add(1L);
        idNaturesDogBreed5.add(1L);
        dogBreedStdInDto5.setDogBreedColors(idColorsDogBreed5);
        dogBreedStdInDto5.setDogBreedNatures(idNaturesDogBreed5);

        dogBreedStdInDto6 = new DogBreedStdInDto();
        dogBreedStdInDto6.setName("pitbull");
        dogBreedStdInDto6.setHeight(40.0);
        dogBreedStdInDto6.setWeight(37.5);
        dogBreedStdInDto6.setLifeExpectancy(10);
        dogBreedStdInDto6.setIdCountry(1L);
        dogBreedStdInDto6.setCountry("united states");
        List<Long> idNaturesDogBreed6 = new ArrayList<Long>();
        idNaturesDogBreed6.add(1L);
        dogBreedStdInDto6.setDogBreedNatures(idNaturesDogBreed6);

        dogBreedStdInDto7 = new DogBreedStdInDto();
        dogBreedStdInDto7.setName("pitbull");
        dogBreedStdInDto7.setHeight(40.0);
        dogBreedStdInDto7.setWeight(37.5);
        dogBreedStdInDto7.setLifeExpectancy(10);
        dogBreedStdInDto7.setIdCountry(1L);
        dogBreedStdInDto7.setCountry("united states");
        List<Long> idColorsDogBreed7 = new ArrayList<Long>();
        idColorsDogBreed7.add(1L);
        dogBreedStdInDto7.setDogBreedColors(idColorsDogBreed7);

        dogBreedStdInDto8 = new DogBreedStdInDto();
        dogBreedStdInDto8.setName("pitbull");
        dogBreedStdInDto8.setHeight(40.0);
        dogBreedStdInDto8.setWeight(37.5);
        dogBreedStdInDto8.setLifeExpectancy(10);
        dogBreedStdInDto8.setIdCountry(1L);
        dogBreedStdInDto8.setCountry("united states");
        List<Long> idColorsDogBreed8 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed8 = new ArrayList<Long>();
        idNaturesDogBreed8.add(1L);
        dogBreedStdInDto8.setDogBreedColors(idColorsDogBreed8);
        dogBreedStdInDto8.setDogBreedNatures(idNaturesDogBreed8);

        dogBreedStdInDto9 = new DogBreedStdInDto();
        dogBreedStdInDto9.setName("pitbull");
        dogBreedStdInDto9.setHeight(40.0);
        dogBreedStdInDto9.setWeight(37.5);
        dogBreedStdInDto9.setLifeExpectancy(10);
        dogBreedStdInDto9.setIdCountry(1L);
        dogBreedStdInDto9.setCountry("united states");
        List<Long> idColorsDogBreed9 = new ArrayList<Long>();
        List<Long> idNaturesDogBreed9 = new ArrayList<Long>();
        idColorsDogBreed9.add(1L);
        dogBreedStdInDto9.setDogBreedColors(idColorsDogBreed9);
        dogBreedStdInDto9.setDogBreedNatures(idNaturesDogBreed9);



    }

    @Test
    public void whenUserGetaDogBreedSuccessfully(){

        when(iDogBreedRepository.existsById(1L)).thenReturn(true);
        when(iDogBreedRepository.findById(dogBreed.getId())).thenReturn(java.util.Optional.ofNullable(dogBreed));
        DogBreedStdOutDto dogBreedStdOutDtoTest = dogBreedService.findById(dogBreed.getId());

        Long expectedIdDogBreed = dogBreed.getId();
        Long actualIdDogBreed =  dogBreedStdOutDtoTest.getId();
        String expectedNameDogBreed = dogBreed.getName();
        String actualName = dogBreedStdOutDtoTest.getName();
        Double expectedWeight = dogBreed.getWeight();
        Double actualWeight = dogBreedStdOutDtoTest.getWeight();
        Double expectedHeight = dogBreed.getHeight();
        Double actualHeight = dogBreedStdOutDtoTest.getHeight();
        Integer expectedLifExpectancy = dogBreed.getLifeExpectancy();
        Integer actualLifeExpectancy = dogBreedStdOutDtoTest.getLifeExpectancy();
        int expectedColorsAmount = dogBreed.getColors().size();
        int actualColorsAmount = dogBreedStdOutDtoTest.getDogBreedColors().size();
        int expectedNaturesAmount = dogBreed.getNatures().size();
        int actualNaturesAmount = dogBreedStdOutDtoTest.getDogBreedNatures().size();

        assertEquals(expectedIdDogBreed, actualIdDogBreed);
        assertTrue(actualName.contains(expectedNameDogBreed));
        assertEquals(expectedHeight,actualHeight);
        assertEquals(expectedWeight,actualWeight);
        assertEquals(expectedLifExpectancy,actualLifeExpectancy);
        assertEquals(expectedNaturesAmount,actualNaturesAmount);
        assertEquals(expectedColorsAmount,actualColorsAmount);
    }

    @Test
    public void whenUserTryToFindDogBreedDoesNotExistAndThrowException(){
        when(iDogBreedRepository.existsById(dogBreed.getId())).thenReturn(false);
        Exception exception = assertThrows(DogBreedDoesNotExistException.class, () -> {
            dogBreedService.findById(dogBreed.getId());
        });
        String expectedMessage = "Dog breed with id 1 does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserFindAllDogBreedsAndDoesNotExistDogBreeds(){
        List<DogBreedStdOutDto> dogBreedStdOutDtos = dogBreedService.findAll();
        assertEquals(0,dogBreedStdOutDtos.size());
    }

    @Test
    public void whenUserFindAllDogBreedsSuccessfully(){
        List<DogBreed> countries = new ArrayList<>();
        countries.add(dogBreed);
        when(iDogBreedRepository.findAll()).thenReturn(countries);
        List<DogBreedStdOutDto> DogBreedStdOutDtos = dogBreedService.findAll();
        assertTrue(DogBreedStdOutDtos.size() > 0);
    }

    @Test
    public void whenUserSaveADogBreedSuccessfully(){
        when(iColorRespository.existsById(color.getId())).thenReturn(true);
        when(iNatureRepository.existsById(nature.getId())).thenReturn(true);
        when(iColorRespository.findById(color.getId())).thenReturn(java.util.Optional.ofNullable(color));
        when(iNatureRepository.findById(nature.getId())).thenReturn(java.util.Optional.ofNullable(nature));
        DogBreedStdOutDto dogBreedStdOutDto = dogBreedService.save(dogBreedStdInDto1);

        Long actualIdDogBreed = dogBreedStdOutDto.getId();
        String expectedNameDogBreed = dogBreedStdOutDto.getName();
        String actualNameDogBreed = dogBreedStdOutDto.getName();
        Double expectedHeightDogBreed = dogBreedStdInDto1.getHeight();
        Double actualHeightDogBreed = dogBreedStdOutDto.getHeight();
        Double expectedWeightDogBreed = dogBreedStdInDto1.getWeight();
        Double actualWeightDogBreed = dogBreedStdOutDto.getWeight();
        Integer expectedLifeExpectancyDogBreed = dogBreedStdInDto1.getLifeExpectancy();
        Integer actualLifeExpectancyDogBreed = dogBreedStdOutDto.getLifeExpectancy();
        int expectedNaturesAmount = dogBreedStdInDto1.getDogBreedColors().size();
        int actualNaturesAmount = dogBreedStdOutDto.getDogBreedNatures().size();
        int expectedColorsAmount = dogBreedStdInDto1.getDogBreedColors().size();
        int actualColorsAmount = dogBreedStdOutDto.getDogBreedColors().size();

        assertNull(actualIdDogBreed);
        assertTrue(actualNameDogBreed.contains(expectedNameDogBreed));
        assertEquals(expectedHeightDogBreed,actualHeightDogBreed);
        assertEquals(expectedWeightDogBreed,actualWeightDogBreed);
        assertEquals(expectedLifeExpectancyDogBreed,actualLifeExpectancyDogBreed);
        assertEquals(expectedColorsAmount,actualColorsAmount);
        assertEquals(expectedNaturesAmount,actualNaturesAmount);

    }

    @Test
    public void whenUserTryToSaveADogBreedWithoutNameMandatoryThrowsException(){
        Exception exception = assertThrows(DogBreedNameMandatoryException.class, () -> {
            dogBreedService.save(dogBreedStdInDto2);
        });
        String expectedMessage = "Name attribute is mandatory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithoutHeightMandatoryThrowsException(){
        Exception exception = assertThrows(DogBreedHeightMandatoryException.class, () -> {
            dogBreedService.save(dogBreedStdInDto3);
        });
        String expectedMessage = "Height attribute is mandatory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithoutWeightMandatoryThrowsException(){
        Exception exception = assertThrows(DogBreedWeightMandatoryException.class, () -> {
            dogBreedService.save(dogBreedStdInDto4);
        });
        String expectedMessage = "Weight attribute is mandatory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithoutLifeEexpectancyMandatoryThrowsException(){
        Exception exception = assertThrows(DogBreedLifeExpectancyMandatoryException.class, () -> {
            dogBreedService.save(dogBreedStdInDto5);
        });
        String expectedMessage = "Life expectancy is mandatory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithoutColorsMandatoryThrowsException(){
        Exception exception = assertThrows(DogBreedColorsMandatoryException.class, () -> {
            dogBreedService.save(dogBreedStdInDto6);
        });
        String expectedMessage = "Colors attribute is mandatory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithZeroColorsThrowsException(){
        Exception exception = assertThrows(DogBreedDoesNotHaveColorException.class, () -> {
            dogBreedService.save(dogBreedStdInDto8);
        });
        String expectedMessage = "Dog breed must have at least one nested color";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithZeroNaturesThrowsException(){
        when(iColorRespository.existsById(dogBreedStdInDto9.getDogBreedColors().get(0))).thenReturn(true);
        when(iColorRespository.findById(dogBreedStdInDto9.getDogBreedColors().get(0))).thenReturn(java.util.Optional.ofNullable(color));
        Exception exception = assertThrows(DogBreedDoesNotHaveNatureException.class, () -> {
            dogBreedService.save(dogBreedStdInDto9);
        });
        String expectedMessage = "Dog breed must have at least one nested nature";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithAColorDoesNotExistThrowsException(){
        when(iColorRespository.existsById(dogBreedStdInDto1.getDogBreedColors().get(0))).thenReturn(false);
        Exception exception = assertThrows(ColorDoesNotExistException.class, () -> {
            dogBreedService.save(dogBreedStdInDto1);
        });
        String expectedMessage = "Color does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenUserTryToSaveADogBreedWithANatureDoesNotExistThrowsException(){
        when(iColorRespository.existsById(dogBreedStdInDto1.getDogBreedColors().get(0))).thenReturn(true);
        when(iColorRespository.findById(dogBreedStdInDto9.getDogBreedColors().get(0))).thenReturn(java.util.Optional.ofNullable(color));
        Exception exception = assertThrows(NatureDoesNotExistException.class, () -> {
            dogBreedService.save(dogBreedStdInDto1);
        });
        String expectedMessage = "Nature does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    }
