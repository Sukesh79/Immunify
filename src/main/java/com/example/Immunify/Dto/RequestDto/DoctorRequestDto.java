package com.example.Immunify.Dto.RequestDto;

import com.example.Immunify.Enum.Gender;
import com.example.Immunify.Model.Center;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorRequestDto {

    int centerId;
    String name;
    int age;
    String emailId;
    String mobNo;
    Gender gender;
}
