package com.example.Immunify.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorResponseDto {

    String name;
    String emailId;
    String mobNo;

    CenterResponseDto centerResponseDto;
}
