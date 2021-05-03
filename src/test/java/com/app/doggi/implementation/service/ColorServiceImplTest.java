package com.app.doggi.implementation.service;

import com.app.doggi.controller.dtos.stdout.ColorStdOutDto;
import com.app.doggi.model.Color;
import com.app.doggi.repository.IColorRespository;
import com.app.doggi.service.implementation.ColorServiceImpl;
import com.app.doggi.utils.exceptions.ColorDoesNotExistException;
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
class ColorServiceImplTest {

    @Mock
    private IColorRespository iColorRespository;

    @InjectMocks
    private ColorServiceImpl colorService;


    private ColorStdOutDto colorStdOutDto;
    private Color color;

    @BeforeEach
    public void setUp() {
        color = new Color();
        color.setId(1L);
        color.setName("red");
        colorStdOutDto = new ColorStdOutDto();
        colorStdOutDto.setId(1L);
        colorStdOutDto.setName("red");
    }

    @Test
    public void whenUserGetaColorSuccessfully(){
        when(iColorRespository.existsById(color.getId())).thenReturn(true);
        when(iColorRespository.findById(color.getId())).thenReturn(java.util.Optional.ofNullable(color));
        ColorStdOutDto colorStdOutDtoTest = colorService.findById(color.getId());
        Long expectedIdColor = color.getId();
        Long actualIdColor =  colorStdOutDtoTest.getId();
        String expectedNameColor = color.getName();
        String actualName = colorStdOutDtoTest.getName();
        assertEquals(expectedIdColor, actualIdColor);
        assertTrue(actualName.contains(expectedNameColor));
    }
    @Test
    public void whenUserTryToFindColorDoesNotExistAndThrowException(){
        when(iColorRespository.existsById(color.getId())).thenReturn(false);
        Exception exception = assertThrows(ColorDoesNotExistException.class, () -> {
            colorService.findById(color.getId());
        });
        String expectedMessage = "Color with id 1 does not exist";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void whenUserFindAllColorsAndDoesNotExistColors(){
        List<ColorStdOutDto> colorStdOutDtos = colorService.findAll();
        assertEquals(0,colorStdOutDtos.size());
    }
    @Test
    public void whenUserFindAllColorsSuccessfully(){
        List<Color> colors = new ArrayList<>();
        colors.add(color);
        when(iColorRespository.findAll()).thenReturn(colors);
        List<ColorStdOutDto> colorStdOutDtos = colorService.findAll();
        assertTrue(colorStdOutDtos.size() > 0);
    }
}