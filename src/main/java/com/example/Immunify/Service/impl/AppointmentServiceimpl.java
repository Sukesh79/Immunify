package com.example.Immunify.Service.impl;

import com.example.Immunify.Dto.RequestDto.AppointmentRequestDto;
import com.example.Immunify.Dto.ResponseDto.AppointmentResponseDto;
import com.example.Immunify.Enum.DoseNo;
import com.example.Immunify.Exception.DoctorNotFoundException;
import com.example.Immunify.Exception.NotEligibleForDoseException;
import com.example.Immunify.Exception.UserNotFoundException;
import com.example.Immunify.Model.*;
import com.example.Immunify.Repository.DoctorRepository;
import com.example.Immunify.Repository.UserRepository;
import com.example.Immunify.Service.AppointmentService;
import com.example.Immunify.Service.Dose1Service;
import com.example.Immunify.Service.Dose2Service;
import com.example.Immunify.Transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceimpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;
    @Autowired
    JavaMailSender emailSender;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User doesn't exist!");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Doctor doesn't exist!!!");
        }

        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();

        if(appointmentRequestDto.getDoseNo()== DoseNo.DOSE1){
            Dose1 dose1 = dose1Service.createDose1(user,appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }

        else{
            // DOSE_2
            if(!user.isDose1Taken()){
                throw new NotEligibleForDoseException("Sorry! You are not yet eligible for Dose 2");
            }

            Dose2 dose2 = dose2Service.createDose2(user,appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Appointment appointment = Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDto.getDoseNo())
                .vaccineType(appointmentRequestDto.getVaccineType())
                .user(user)
                .doctor(doctor)
                .build();

        user.getAppointments().add(appointment);
        User savedUser = userRepository.save(user);

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);
        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);

        //send Mail
        String text = "Congrats!!" + user.getName() + " Your dose "+ appointmentRequestDto.getDoseNo() + " has been booked!!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("boots2578@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked !!!");
        message.setText(text);
        emailSender.send(message);

        return AppointmentTransformer.AppointmentToAppointmentResponseDto(savedAppointment);
    }
}
