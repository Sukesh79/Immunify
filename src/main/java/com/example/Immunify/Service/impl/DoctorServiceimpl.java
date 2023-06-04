package com.example.Immunify.Service.impl;

import com.example.Immunify.Dto.RequestDto.DoctorRequestDto;
import com.example.Immunify.Dto.ResponseDto.DoctorResponseDto;
import com.example.Immunify.Exception.CenterNotPresentException;
import com.example.Immunify.Exception.DoctorNotFoundException;
import com.example.Immunify.Model.Center;
import com.example.Immunify.Model.Doctor;
import com.example.Immunify.Repository.CenterRepository;
import com.example.Immunify.Repository.DoctorRepository;
import com.example.Immunify.Service.DoctorService;
import com.example.Immunify.Transformer.CenterTransformer;
import com.example.Immunify.Transformer.DoctorTransfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceimpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    CenterRepository centerRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {

        Optional<Center> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());

        if(optionalCenter.isEmpty()) throw new CenterNotPresentException("center Not Exist");

        Center center = optionalCenter.get();

        Doctor doctor = DoctorTransfomer.doctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setCenter(center);

        center.getDoctors().add(doctor);

        Center savedCenter = centerRepository.save(center);

        Doctor savedDoctor = savedCenter.getDoctors().get(savedCenter.getDoctors().size()-1);

        return DoctorTransfomer.doctorToDoctorResponseDto(savedDoctor);

    }

    @Override
    public DoctorResponseDto getDoctor(int id) throws DoctorNotFoundException {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isEmpty()) throw new DoctorNotFoundException("Doctor Doesn't Exist");

        Doctor doctor = optionalDoctor.get();
        return DoctorTransfomer.doctorToDoctorResponseDto(doctor);
    }
}
