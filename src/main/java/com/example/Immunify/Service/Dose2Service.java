package com.example.Immunify.Service;

import com.example.Immunify.Enum.VaccineType;
import com.example.Immunify.Model.Dose2;
import com.example.Immunify.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface Dose2Service {
    public Dose2 createDose2(User user, VaccineType vaccineType);
}
