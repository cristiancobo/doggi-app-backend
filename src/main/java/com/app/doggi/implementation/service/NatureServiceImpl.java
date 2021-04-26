package com.app.doggi.implementation.service;

import com.app.doggi.dtos.stdout.NatureStdOutDto;
import com.app.doggi.interfaces.mapper.INatureMapper;
import com.app.doggi.interfaces.mapper.INatureMapperImpl;
import com.app.doggi.interfaces.service.INatureService;
import com.app.doggi.model.Nature;
import com.app.doggi.repository.INatureRepository;
import com.app.doggi.utils.exceptions.NatureDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class representing Nature service implementation.
 * @version 1.0
 */
@Service
public class NatureServiceImpl implements INatureService {

    private INatureRepository iNatureRespository;

    @Autowired
    public NatureServiceImpl(INatureRepository iNatureRespository) {
        this.iNatureRespository = iNatureRespository;
    }

    @Override
    public NatureStdOutDto findById(Long id) {
        if(!(iNatureRespository.existsById(id))){
            throw new NatureDoesNotExistException("Nature with id "+id+ " does not exist" );
        }
        Nature Nature = iNatureRespository.findById(id).get();
        NatureStdOutDto NatureStdOutDto = INatureMapper.INSTANCE.asNatureToNatureStdOutDto(Nature);
        return NatureStdOutDto;
    }

    @Override
    public List<NatureStdOutDto> findAll() {
        List<Nature> Natures = (List<Nature>) iNatureRespository.findAll();
        List<NatureStdOutDto> NatureStdOutDtos = INatureMapperImpl.INSTANCE.asListNatureEntitiesToListNatureStdInDto(Natures);
        return NatureStdOutDtos;
    }
}