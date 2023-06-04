package com.example.Immunify.Service;

import com.example.Immunify.Dto.RequestDto.AppointmentRequestDto;
import com.example.Immunify.Dto.ResponseDto.AppointmentResponseDto;
import com.example.Immunify.Exception.DoctorNotFoundException;
import com.example.Immunify.Exception.NotEligibleForDoseException;
import com.example.Immunify.Exception.UserNotFoundException;



public interface AppointmentService {
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException;
}
