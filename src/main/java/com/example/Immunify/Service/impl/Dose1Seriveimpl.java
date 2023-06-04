package com.example.Immunify.Service.impl;

import com.example.Immunify.Enum.VaccineType;
import com.example.Immunify.Model.Dose1;
import com.example.Immunify.Model.User;
import com.example.Immunify.Service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1Seriveimpl implements Dose1Service {
    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {
         return  Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
