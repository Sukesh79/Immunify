package com.example.Immunify.Controller;

import com.example.Immunify.Dto.RequestDto.AppointmentRequestDto;
import com.example.Immunify.Dto.ResponseDto.AppointmentResponseDto;
import com.example.Immunify.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Appointment")
public class AppointmentController {
   @Autowired
   AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try {
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity(appointmentResponseDto, HttpStatus.valueOf(302));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
