package com.app.doggi.interfaces.mapper;



import com.app.doggi.dtos.stdout.ColorStdOutDto;
import com.app.doggi.model.Color;

import java.util.List;

public interface IColorMapper {

    ColorStdOutDto asColorToColorStdOutDto(Color color);
    List<ColorStdOutDto> asListColorEntitiesToListColorStdInDto(List<Color> colors);
}


