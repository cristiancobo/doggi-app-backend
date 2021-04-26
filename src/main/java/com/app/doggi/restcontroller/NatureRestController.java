package com.app.doggi.restcontroller;

import com.app.doggi.dtos.stdout.NatureStdOutDto;
import com.app.doggi.interfaces.service.INatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class representing a nature controller
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/Natures")
public class NatureRestController {

    private INatureService iNatureService;

    @Autowired
    public NatureRestController(INatureService iNatureService) {
        this.iNatureService = iNatureService;
    }

    @GetMapping("/")
    public ResponseEntity<List<NatureStdOutDto>> findAll(){
        List<NatureStdOutDto> NatureStdOutDtos = iNatureService.findAll();
        return new ResponseEntity<List<NatureStdOutDto>>(NatureStdOutDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NatureStdOutDto> findById(@PathVariable Long id){
        NatureStdOutDto NatureStdOutDto = iNatureService.findById(id);
        return new ResponseEntity<NatureStdOutDto>(NatureStdOutDto, HttpStatus.OK);

    }
}
