package com.example.Immunify.Service.impl;

import com.example.Immunify.Enum.VaccineType;
import com.example.Immunify.Model.Dose1;
import com.example.Immunify.Model.Dose2;
import com.example.Immunify.Model.User;
import com.example.Immunify.Service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2Serviceimpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
        return  Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
