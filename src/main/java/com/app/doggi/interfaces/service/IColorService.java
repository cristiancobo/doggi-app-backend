package com.app.doggi.interfaces.service;

import com.app.doggi.dtos.stdout.ColorStdOutDto;

import java.util.List;

public interface IColorService {

    public ColorStdOutDto findById(Long id);

    public List<ColorStdOutDto> findAll();
}
