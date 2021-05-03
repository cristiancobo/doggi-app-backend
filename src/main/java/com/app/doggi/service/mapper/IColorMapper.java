package com.app.doggi.service.mapper;



import com.app.doggi.controller.dtos.stdout.ColorStdOutDto;
import com.app.doggi.model.Color;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface IColorMapper {
    IColorMapper INSTANCE = Mappers.getMapper(IColorMapper.class);
    ColorStdOutDto asColorToColorStdOutDto(Color color);
    List<ColorStdOutDto> asListColorEntitiesToListColorStdInDto(List<Color> colors);
}


