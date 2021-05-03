package com.app.doggi.service.interfaces;

import com.app.doggi.controller.dtos.stdout.ColorStdOutDto;

import java.util.List;

public interface IColorService {

    public ColorStdOutDto findById(Long id);

    public List<ColorStdOutDto> findAll();
}
