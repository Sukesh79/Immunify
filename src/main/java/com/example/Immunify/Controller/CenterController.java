package com.example.Immunify.Controller;

import com.example.Immunify.Dto.RequestDto.CenterRequestDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import com.example.Immunify.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Center")
public class CenterController {
    @Autowired
    CenterService centerService;

    @PostMapping("/add")
    public ResponseEntity addCenter(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponseDto centerResponseDto = centerService.addCenter(centerRequestDto);
        return new ResponseEntity(centerResponseDto, HttpStatus.valueOf(302));
    }
}
