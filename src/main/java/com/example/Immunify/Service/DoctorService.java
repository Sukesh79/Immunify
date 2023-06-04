package com.example.Immunify.Service;

import com.example.Immunify.Dto.RequestDto.DoctorRequestDto;
import com.example.Immunify.Dto.ResponseDto.DoctorResponseDto;
import com.example.Immunify.Exception.CenterNotPresentException;
import com.example.Immunify.Exception.DoctorNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;

    public DoctorResponseDto getDoctor(int id) throws DoctorNotFoundException;
}
