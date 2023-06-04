package com.example.Immunify.Dto.ResponseDto;

import com.example.Immunify.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterResponseDto {
    String name;
    String location;
    CenterType centerType;
}
