package com.example.Immunify.Controller;

import com.example.Immunify.Dto.RequestDto.DoctorRequestDto;
import com.example.Immunify.Dto.ResponseDto.DoctorResponseDto;
import com.example.Immunify.Exception.CenterNotPresentException;
import com.example.Immunify.Exception.DoctorNotFoundException;
import com.example.Immunify.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto){

        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        } catch (CenterNotPresentException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getDoctor(@PathVariable int id){
       try {
           DoctorResponseDto doctorResponseDto = doctorService.getDoctor(id);
           return new ResponseEntity(doctorResponseDto, HttpStatus.FOUND);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }
}
