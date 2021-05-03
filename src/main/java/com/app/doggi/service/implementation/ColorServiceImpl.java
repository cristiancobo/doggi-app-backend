package com.app.doggi.service.implementation;

import com.app.doggi.controller.dtos.stdout.ColorStdOutDto;
import com.app.doggi.service.mapper.IColorMapper;
import com.app.doggi.service.mapper.IColorMapperImpl;
import com.app.doggi.service.interfaces.IColorService;
import com.app.doggi.model.Color;
import com.app.doggi.repository.IColorRespository;
import com.app.doggi.utils.exceptions.ColorDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class representing color service implementation.
 * @version 1.0
 */
@Service
public class ColorServiceImpl implements IColorService {

    private IColorRespository iColorRespository;

    @Autowired
    public ColorServiceImpl(IColorRespository iColorRespository) {
        this.iColorRespository = iColorRespository;
    }

    @Override
    public ColorStdOutDto findById(Long id) {
        if(!(iColorRespository.existsById(id))){
            throw new ColorDoesNotExistException("Color with id "+id+ " does not exist" );
        }
        Color color = iColorRespository.findById(id).get();
        ColorStdOutDto colorStdOutDto = IColorMapper.INSTANCE.asColorToColorStdOutDto(color);
        return colorStdOutDto;
    }

    @Override
    public List<ColorStdOutDto> findAll() {
        List<Color> colors = (List<Color>) iColorRespository.findAll();
        List<ColorStdOutDto> colorStdOutDtos = IColorMapperImpl.INSTANCE.asListColorEntitiesToListColorStdInDto(colors);
        return colorStdOutDtos;
    }
}
