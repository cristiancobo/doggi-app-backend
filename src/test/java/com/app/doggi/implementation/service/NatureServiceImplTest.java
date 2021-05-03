package com.app.doggi.implementation.service;

import com.app.doggi.controller.dtos.stdout.NatureStdOutDto;
import com.app.doggi.model.Nature;
import com.app.doggi.repository.INatureRepository;
import com.app.doggi.service.implementation.NatureServiceImpl;
import com.app.doggi.utils.exceptions.NatureDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class NatureServiceImplTest {

    @Mock
    private INatureRepository iNatureRespository;

    @InjectMocks
    private NatureServiceImpl NatureService;


    private NatureStdOutDto NatureStdOutDto;
    private Nature Nature;

    @BeforeEach
    public void setUp() {
        Nature = new Nature();
        Nature.setId(1L);
        Nature.setName("red");
        NatureStdOutDto = new NatureStdOutDto();
        NatureStdOutDto.setId(1L);
        NatureStdOutDto.setName("red");
    }

    @Test
    public void whenUserGetaNatureSuccessfully(){
        when(iNatureRespository.existsById(Nature.getId())).thenReturn(true);
        when(iNatureRespository.findById(Nature.getId())).thenReturn(java.util.Optional.ofNullable(Nature));
        NatureStdOutDto NatureStdOutDtoTest = NatureService.findById(Nature.getId());
        Long expectedIdNature = Nature.getId();
        Long actualIdNature =  NatureStdOutDtoTest.getId();
        String expectedNameNature = Nature.getName();
        String actualName = NatureStdOutDtoTest.getName();
        assertEquals(expectedIdNature, actualIdNature);
        assertTrue(actualName.contains(expectedNameNature));
    }
    @Test
    public void whenUserTryToFindNatureDoesNotExistAndThrowException(){
        when(iNatureRespository.existsById(Nature.getId())).thenReturn(false);
        Exception exception = assertThrows(NatureDoesNotExistException.class, () -> {
            NatureService.findById(Nature.getId());
        });
        String expectedMessage = "Nature with id 1 does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void whenUserFindAllNaturesAndDoesNotExistNatures(){
        List<NatureStdOutDto> NatureStdOutDtos = NatureService.findAll();
        assertEquals(0,NatureStdOutDtos.size());
    }
    @Test
    public void whenUserFindAllNaturesSuccessfully(){
        List<Nature> Natures = new ArrayList<>();
        Natures.add(Nature);
        when(iNatureRespository.findAll()).thenReturn(Natures);
        List<NatureStdOutDto> NatureStdOutDtos = NatureService.findAll();
        assertTrue(NatureStdOutDtos.size() > 0);
    }
}
