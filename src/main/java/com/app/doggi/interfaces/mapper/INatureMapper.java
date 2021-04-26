package com.app.doggi.interfaces.mapper;

import com.app.doggi.dtos.stdout.NatureStdOutDto;
import com.app.doggi.model.Nature;

import java.util.List;

public interface INatureMapper {

    NatureStdOutDto asNatureToNatureStdOutDto(Nature nature);
    List<NatureStdOutDto> asListNatureEntitiesToListNatureStdInDto(List<Nature> nature);
}
