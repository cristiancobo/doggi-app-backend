package com.app.doggi.service.mapper;

import com.app.doggi.controller.dtos.stdout.NatureStdOutDto;
import com.app.doggi.model.Nature;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface INatureMapper {
    INatureMapper INSTANCE = Mappers.getMapper(INatureMapper.class);
    NatureStdOutDto asNatureToNatureStdOutDto(Nature nature);
    List<NatureStdOutDto> asListNatureEntitiesToListNatureStdInDto(List<Nature> nature);
}
