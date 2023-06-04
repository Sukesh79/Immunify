package com.example.Immunify.Transformer;

import com.example.Immunify.Dto.RequestDto.DoctorRequestDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import com.example.Immunify.Dto.ResponseDto.DoctorResponseDto;
import com.example.Immunify.Model.Doctor;

public class DoctorTransfomer {
    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

    public static DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor){
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponseDto(doctor.getCenter());

        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}
