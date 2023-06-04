package com.example.Immunify.Transformer;

import com.example.Immunify.Dto.RequestDto.AppointmentRequestDto;
import com.example.Immunify.Dto.ResponseDto.AppointmentResponseDto;
import com.example.Immunify.Dto.ResponseDto.CenterResponseDto;
import com.example.Immunify.Model.Appointment;

public class AppointmentTransformer {
    static public Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto){
        return Appointment.builder()
                .doseNo(appointmentRequestDto.getDoseNo())
                .vaccineType(appointmentRequestDto.getVaccineType())
                .build();
    }

    public static AppointmentResponseDto AppointmentToAppointmentResponseDto(Appointment appointment){
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToCenterResponseDto(appointment.getDoctor().getCenter());

        return AppointmentResponseDto.builder()
                .userName(appointment.getUser().getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .centerResponseDto(centerResponseDto)
                .doctorName(appointment.getDoctor().getName())
                .vaccineType(appointment.getVaccineType())
                .build();
    }
}
