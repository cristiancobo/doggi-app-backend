package com.app.doggi.interfaces.service;



import com.app.doggi.dtos.stdout.NatureStdOutDto;

import java.util.List;

public interface INatureService {

    public NatureStdOutDto findById(Long id);

    public List<NatureStdOutDto> findAll();
}
