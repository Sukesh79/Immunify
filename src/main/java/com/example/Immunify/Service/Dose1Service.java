package com.example.Immunify.Service;

import com.example.Immunify.Enum.VaccineType;
import com.example.Immunify.Model.Dose1;
import com.example.Immunify.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}
