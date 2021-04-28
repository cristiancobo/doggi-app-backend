package com.app.doggi.restcontroller;


import com.app.doggi.dtos.stdout.ColorStdOutDto;
import com.app.doggi.interfaces.service.IColorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class representing a dog color controller
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/colors")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ColorRestController {

    private IColorService iColorService;

    @Autowired
    public ColorRestController(IColorService iColorService) {
        this.iColorService = iColorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ColorStdOutDto>> findAll(){
        List<ColorStdOutDto> colorStdOutDtos = iColorService.findAll();
        return new ResponseEntity<List<ColorStdOutDto>>(colorStdOutDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColorStdOutDto> findById(@PathVariable Long id){
        ColorStdOutDto colorStdOutDto = iColorService.findById(id);
        return new ResponseEntity<ColorStdOutDto>(colorStdOutDto, HttpStatus.OK);

    }
}
