package com.example.Immunify.Dto.RequestDto;

import com.example.Immunify.Enum.DoseNo;
import com.example.Immunify.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentRequestDto {
    DoseNo doseNo;
    int userId;
    int doctorId;

    VaccineType vaccineType;
}
