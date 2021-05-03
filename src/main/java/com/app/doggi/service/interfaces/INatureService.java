package com.app.doggi.service.interfaces;



import com.app.doggi.controller.dtos.stdout.NatureStdOutDto;

import java.util.List;

public interface INatureService {

    public NatureStdOutDto findById(Long id);

    public List<NatureStdOutDto> findAll();
}
