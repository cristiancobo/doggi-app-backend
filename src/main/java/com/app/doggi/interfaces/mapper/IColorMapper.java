package com.app.doggi.interfaces.mapper;



import com.app.doggi.dtos.stdout.ColorStdOutDto;
import com.app.doggi.model.Color;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface IColorMapper {

    ColorStdOutDto asColorToColorStdOutDto(Color color);
    List<ColorStdOutDto> asListColorEntitiesToListColorStdInDto(List<Color> colors);
}


